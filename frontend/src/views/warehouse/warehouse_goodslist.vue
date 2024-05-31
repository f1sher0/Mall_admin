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
            
       
            <el-button style="margin-left: 10px" type="primary"    @click="loadPost"  >搜 索</el-button>
            <el-button type="info" @click="reset">重 置</el-button>
            <el-button type="success" @click="add">新 增</el-button>
            <el-button type="primary" @click="exportData">导出数据</el-button>
        </div>
        <!-- Table -->
        <el-table :data="filteredGoods" border stripe style="width: 100%">
          <el-table-column prop="warehouseId" label="仓库ID" width="180"></el-table-column>
          <el-table-column prop="warehouseName" label="仓库名称" width="180"></el-table-column>
          <el-table-column prop="goodsName" label="商品名称" width="180"></el-table-column>
          <el-table-column prop="sellingPrice" label="销售价格" width="180"></el-table-column>
          <el-table-column prop="stockQuantity" label="库存数量" width="180"></el-table-column>
        </el-table>

        <!-- Pagination -->
        <div class="mt-4">
          <el-pagination
            @current-change="handleCurrentChange"
            :current-page="currentPage"
            :page-size="pageSize"
            layout="prev, pager, next"
            :total="totalGoods"
          ></el-pagination>
        </div>
      </main>
    </div>
  </div>
</template>

 
 
 
<script>
import { ref, onMounted } from 'vue'
import Header from '../../partials/Header.vue'
import DashboardAvatars from '../../partials/dashboard/DashboardAvatars.vue'
import Sidebar_warehouse from '../../partials/Sidebar_warehouse.vue'
 
import axios from 'axios';

export default {
  name: 'Dashboard',
  components: {
    Sidebar_warehouse,
    Header,
    DashboardAvatars,
  },
  data() {
  return {
    sidebarOpen: false,
    search: '',
    currentPage: 1,
    pageSize: 10,
    warehouseGoods: [
      // Your goods data here
    ]
  }
},
computed: {
  filteredGoods() {
    const startIndex = (this.currentPage - 1) * this.pageSize;
    const endIndex = this.currentPage * this.pageSize;
    const filtered = this.warehouseGoods.filter(good => 
      good.goodsName.toLowerCase().includes(this.search.toLowerCase()) ||
      good.warehouseName.toLowerCase().includes(this.search.toLowerCase())
    );
    this.totalGoods = filtered.length;
    return filtered.slice(startIndex, endIndex);
  }
},
  setup() {

    const sidebarOpen = ref(false)
  const warehouseGoods = ref([])

  const fetchWarehouseGoods = async (id = null) => {
    try {
      const response = await axios.get('/warehouseGoods/info', {
        params: {
          id: 1
        }
      })
      if (response.data.code === '200') {
        warehouseGoods.value = response.data.data
      }
    } catch (error) {
      console.error('Failed to fetch warehouse goods info:', error)
    }
  }

  onMounted(() => {
    fetchWarehouseGoods()
  })
  return {
    sidebarOpen,
    warehouseGoods,
  }
  },
  methods: {
  handleCurrentChange(page) {
    this.currentPage = page;
  },
  exportData() {
    this.$axios
      .get("http://localhost:5052/stores/LeftExport", {
        responseType: "blob", // 告诉 axios 返回类型为二进制数据
      })
      .then((res) => {
        // 创建一个 Blob 对象，用于保存二进制数据
        const blob = new Blob([res.data], {
          type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
        });

        // 创建一个下载链接
        const link = document.createElement("a");
        link.href = URL.createObjectURL(blob);

        // 设置下载文件的名称
        const fileName = "库存信息表.xlsx";
        link.download = fileName;

        // 模拟点击下载链接
        link.click();

        // 释放链接占用的资源
        URL.revokeObjectURL(link.href);
      })
      .catch((error) => {
        console.error("导出失败", error);
      });
    } 
}
}
</script>
<style scoped>
/* Add any custom styles here */
</style>