<template>
  <div class="flex h-[100dvh] overflow-hidden">
    <!-- Sidebar -->
    <Sidebar_warehouse :sidebarOpen="sidebarOpen" @close-sidebar="sidebarOpen = false" />

    <!-- Content area -->
    <div class="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden">
      <!-- Site header -->
      <Header :sidebarOpen="sidebarOpen" @toggle-sidebar="sidebarOpen = !sidebarOpen" />
      
      <main class="grow dark:bg-slate-900 p-4">
        <!-- Search bar -->
        <div style="margin-bottom: 10px"> 
           <el-input v-model="search" placeholder="搜索商品..." @input="handleSearch" class="w-1/3"></el-input>
          <el-button style="margin-left: 10px" type="primary" @click="loadPost">搜 索</el-button>
          <el-button type="info" @click="reset">重 置</el-button>
          <el-button type="success" @click="add">新 增</el-button>
          <el-button type="primary" @click="exportData">导出数据</el-button>
        </div>
        <!-- Table -->
        <el-table :data="paginatedGoods" border stripe style="width: 100%" max-height="250" v-loading="loading"
          :default-sort="{ prop: 'sellingPrice', order: 'descending' }">
          <el-table-column fixed prop="warehouseId" label="仓库ID" width="180"></el-table-column>
          <el-table-column prop="warehouseName" label="仓库名称" width="180">
            <template #default="{ row }">
              <HighlightText :text="row.warehouseName" :query="search" />
            </template>
          </el-table-column>
          <el-table-column prop="goodsName" label="商品名称" width="180">
            <template #default="{ row }">
              <HighlightText :text="row.goodsName" :query="search" />
            </template>
          </el-table-column>
          <el-table-column prop="sellingPrice" sortable label="销售价格" width="180"></el-table-column>
          <el-table-column prop="stockQuantity" label="库存数量" width="180"></el-table-column>
        </el-table>

        <!-- Pagination -->
        <div class="mt-4">
          <el-pagination
            @current-change="handleCurrentChange"
            @size-change="handleSizeChange"
            :current-page="currentPage"
            :page-size="pageSize"
            :page-sizes="[5,10,15,20]"
            layout="total, sizes, prev, pager, next"
            :total="totalGoods">
          </el-pagination>
        </div>
      </main>
    </div>
  </div>
</template>

<script>
import { ref, onMounted, computed } from 'vue'
import axios from 'axios'
import Header from '../../partials/Header.vue'
import Sidebar_warehouse from '../../partials/Sidebar_warehouse.vue'
import HighlightText from '../HighlightText.vue'
export default {
  name: 'Dashboard', 
  components: {
    Sidebar_warehouse,
    Header,
    HighlightText  ,
  },
 
  setup() {
    const sidebarOpen = ref(false)
    const search = ref('')
    const currentPage = ref(1)
    const pageSize = ref(5)
    const totalGoods = ref(0)
    const warehouseGoods = ref([])
    const loading = ref(false)

    const fetchWarehouseGoods = async (id = null) => {
      loading.value = true
      try {
        const response = await axios.get('http://localhost:5052/api/warehouseGoods/info', {
          params: {
            id: id
          }
        })
        if (response.data.code === '200') {
          warehouseGoods.value = response.data.data
          totalGoods.value = warehouseGoods.value.length
        }
      } catch (error) {
        console.error('Failed to fetch warehouse goods info:', error)
      } finally {
        loading.value = false
      }
    }
//这里是前端进行过滤信息,实现搜索功能,不必每次搜索进行请求后端,更加高效
    const filteredGoods = computed(() => {
      return warehouseGoods.value.filter(good => 
        good.goodsName.toLowerCase().includes(search.value.toLowerCase()) ||
        good.warehouseName.toLowerCase().includes(search.value.toLowerCase())
      );
    })
 
    const handleSearch = () => {
      // 这里不需要做任何事情，因为过滤是通过计算属性   filteredGoods函数完成的
    }
    const paginatedGoods = computed(() => {
      const startIndex = (currentPage.value - 1) * pageSize.value;
      const endIndex = currentPage.value * pageSize.value;
      return filteredGoods.value.slice(startIndex, endIndex);
    })

    const handleCurrentChange = (page) => {
      currentPage.value = page;
    }
 
    const handleSizeChange = (size) => {
      pageSize.value = size;
      currentPage.value = 1; //默认的是第一页,不是以0开始  
    }

    const exportData = () => {
      axios.get("http://localhost:5052/api/warehouseGoods/LeftExportInfo", {
        responseType: "blob"
      }).then((res) => {
        const blob = new Blob([res.data], {
          type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
        });
        const link = document.createElement("a");
        link.href = URL.createObjectURL(blob);
        const fileName = "库存信息表.xlsx";
        link.download = fileName;
        link.click();
        URL.revokeObjectURL(link.href);
      }).catch((error) => {
        console.error("导出失败", error);
      });
    }

    const add = () => {
      fetchWarehouseGoods()
    }

    const reset = () => {
      search.value = ''
      fetchWarehouseGoods()
    }

    onMounted(() => {
      fetchWarehouseGoods()
    })

    return {
      sidebarOpen,
      search,
      currentPage,
      pageSize,
      totalGoods,
      warehouseGoods,
      filteredGoods,
      paginatedGoods,
      fetchWarehouseGoods,
      handleCurrentChange,
      handleSizeChange,
      exportData,
      reset,
      loading
    }
  }
}
</script>

<style scoped>
body {
  margin: 0;
}

.example-showcase .el-loading-mask {
  z-index: 9;
}
</style>
