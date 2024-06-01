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
          <el-input v-model="search" placeholder="搜索商品..." class="w-1/3"></el-input>
          <el-button style="margin-left: 10px" type="primary" @click="loadPost">搜 索</el-button>
          <el-button type="info" @click="reset">重 置</el-button>
          <el-button type="success" @click="add">新 增</el-button>
          <el-button type="primary" @click="exportData">导出数据</el-button>
        </div>
        <!-- Table -->
        <el-table :data="filteredGoods" border stripe height="250" style="width: 100%" max-height="250" v-loading="loading"
          :default-sort="{ prop: 'sellingPrice', order: 'descending' }">
          <el-table-column fixed prop="warehouseId" label="仓库ID" width="180"></el-table-column>
          <el-table-column prop="warehouseName" label="仓库名称" width="180"></el-table-column>
          <el-table-column prop="goodsName" label="商品名称" width="180"></el-table-column>
          <el-table-column prop="sellingPrice" sortable label="销售价格" width="180"></el-table-column>
          <el-table-column prop="stockQuantity" label="库存数量" width="180"></el-table-column>
        </el-table>

        <!-- Pagination -->
        <div class="mt-4">
          <el-pagination
            @current-change="handleCurrentChange"
            :current-page="currentPage"
            :page-size="pageSize"
            layout="prev, pager, next"
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

export default {
  name: 'Dashboard',
  components: {
    Sidebar_warehouse,
    Header,
  },
  setup() {
    const sidebarOpen = ref(false)
    const search = ref('')
    const currentPage = ref(1)
    const pageSize = ref(10)
    const totalGoods = ref(0)
    const warehouseGoods = ref([])
    const loading = ref(false)  // 添加loading状态
    const fetchWarehouseGoods = async (id = null) => {
      loading.value = true  // 请求开始时设置loading为true
      try {
        const response = await axios.get('http://localhost:5052/api/warehouseGoods/info', {
          params: {
            id: 1
          }
        })
        if (response.data.code === '200') {
          warehouseGoods.value = response.data.data
        }
      } catch (error) {
        console.error('Failed to fetch warehouse goods info:', error)
      }finally {
        loading.value = false  // 请求完成后设置loading为false
      }
    }

    const filteredGoods = computed(() => {
      const startIndex = (currentPage.value - 1) * pageSize.value;
      const endIndex = currentPage.value * pageSize.value;
      const filtered = warehouseGoods.value.filter(good => 
        good.goodsName.toLowerCase().includes(search.value.toLowerCase()) ||
        good.warehouseName.toLowerCase().includes(search.value.toLowerCase())
      );
      totalGoods.value = filtered.length;
      return filtered.slice(startIndex, endIndex);
    })

    const handleCurrentChange = (page) => {
      currentPage.value = page;
    }

    const exportData = () => {
      axios.get("http://localhost:5052/stores/LeftExport", {
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
       //todo 
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
      fetchWarehouseGoods,
      handleCurrentChange,
      exportData,
      reset,
      loading  // 将loading暴露给模板
    }
  }
}
</script>

<style scoped>
body {
  margin: 0;
}
---将loading暴露给模板
.example-showcase .el-loading-mask {
  z-index: 9;    
}
</style>
