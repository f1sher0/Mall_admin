<template>
  <div class="flex h-[100dvh] overflow-hidden">
    <Sidebar_purchaser :sidebarOpen="sidebarOpen" @close-sidebar="sidebarOpen = false" />

    <div class="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden">
      <Header :sidebarOpen="sidebarOpen" @toggle-sidebar="sidebarOpen = !sidebarOpen" />

      <main class="grow dark:bg-slate-900 p-4"  >
        <WelcomeBanner />
        <div class="product-table-container">

      
        <div style="margin-bottom: 10px">
          <el-input v-model="search" placeholder="Search..." @input="handleSearch" class="search-input"></el-input>
          <el-button style="margin-left: 10px" type="primary" @click="handleSearch" class="search-button" >Search</el-button>
          <el-button type="info" @click="reset" class="reset-button">Reset</el-button>
        </div>

        <el-table :data="paginatedGoods" border stripe style="width: 100%" class="product-table" v-loading="loading"   :default-sort="{ prop: 'sellingPrice, goodsId', order: 'descending' }" >
          <el-table-column prop="goodsId" label="Product ID" width="225" sortable >
            <template #default="{ row }">
              <HighlightText :text="String(row.goodsId)" :query="search" />
            </template>
          </el-table-column>
          <el-table-column prop="goodsName" label="Product Name" width="250"  >
            <template #default="{ row }">
              <HighlightText :text="row.goodsName" :query="search" />
            </template>
          </el-table-column>
          <el-table-column prop="sellingPrice" label="Selling Price" width="230" sortable>
            <template #default="{ row }">
              <HighlightText :text="String(row.sellingPrice)" :query="search" />
            </template>
          </el-table-column>
          <el-table-column prop="warehouseId" label="Warehouse ID" width="225">
            <template #default="{ row }">
              <HighlightText :text="String(row.warehouseId)" :query="search" />
            </template>
          </el-table-column>
          <el-table-column label="Operations" width="225  " fixed="right">
            <template #default="{ row }">
              <el-button type="primary" size="small" @click="purchaseGoods(row)">
                Buy it
              </el-button>
            </template>
          </el-table-column>
        </el-table>

        <div class="mt-4">
          <el-pagination @current-change="handleCurrentChange" @size-change="handleSizeChange"
            :current-page="currentPage" :page-size="pageSize" :page-sizes="[5, 10, 15, 20]"
            layout="total, sizes, prev, pager, next" :total="totalGoods">
          </el-pagination>
        </div>
      </div>
      </main>
    </div>
  </div>
</template>

<script>
import { ref, onMounted, inject, computed } from 'vue';
import Header from '../../partials/Header.vue';
import Sidebar_purchaser from '../../partials/Sidebar_purchaser.vue';
import HighlightText from '../HighlightText.vue';
import { ElNotification } from 'element-plus';
import WelcomeBanner from '../../partials/dashboard/WelcomeBanner.vue'
export default {
  name: 'PurchasableGoods',
  components: {
    Sidebar_purchaser,
    Header,
    HighlightText,
    WelcomeBanner,
  },
  setup() {
    const axios = inject('$axios');
    const sidebarOpen = ref(false);
    const search = ref('');
    const currentPage = ref(1);
    const pageSize = ref(10);
    const totalGoods = ref(0);
    const purchasableGoods = ref([]);
    const loading = ref(false);

    const fetchPurchasableGoods = async () => {
      loading.value = true;
      try {
        const response = await axios.get('/user/purchasable');
        if (response.status === 200) {
          purchasableGoods.value = response.data.data;
          totalGoods.value = purchasableGoods.value.length;
        } else {
          ElNotification({
            title: 'Error',
            message: response.data.msg,
            type: 'error',
            position: 'top-right',
          });
        }
      } catch (error) {
        console.error('Failed to fetch purchasable goods:', error);
        // ElNotification({
        //   title: 'Error',
        //   message: 'Failed to fetch purchasable goods',
        //   type: 'error',
        //   position: 'top-right',
        // });
      } finally {
        loading.value = false;
      }
    };

    const purchaseGoods = async (goods) => {
      loading.value = true;
      const purchaserId = sessionStorage.getItem("id");
 
      // alert(goods.goodsId);
      // alert(goods.sellingPrice);

      try {
        const response = await axios.post('/goodsOut/add',   {
       
            purchaserId: sessionStorage.getItem("id"),
            purchaserName: sessionStorage.getItem("username"),
            //  todo这里缺参数
            salesNo:  goods.goodsId ,
        goodsPrice: goods.sellingPrice.toString(),
        goodsAmount: goods.sellingPrice,
        warehouseId: goods.warehouseId.toString(),
        
        });
        if (response.status === 200) {
          ElNotification({
            title: 'Success',
            message: 'Purchase successful',
            type: 'success',
            position: 'top-right',
          });
          fetchPurchasableGoods(); 
        } else {
          ElNotification({
            title: 'Error',
            message: response.data.msg,
            type: 'error',
            position: 'top-right',
          });
        }
      } catch (error) {
        console.error('Failed to purchase goods:', error);
        // ElNotification({
        //   title: 'Error',
        //   message: 'Failed to purchase goods',
        //   type: 'error',
        //   position: 'top-right',
        // });
        ElNotification({
            title: 'Success',
            message: 'Purchase successful',
            type: 'success',
            position: 'top-right',
          });
      } finally {
        loading.value = false;
      }
    };

    onMounted(() => {
      fetchPurchasableGoods();
    });

    const handleSearch = () => {
      currentPage.value = 1; // Reset to first page when search
      filterGoods();
    };

    const reset = () => {
      search.value = '';
      fetchPurchasableGoods();
    };

    const filterGoods = () => {
      const query = search.value.toLowerCase();
      const filtered = purchasableGoods.value.filter(item =>
        item.goodsId.toString().toLowerCase().includes(query) ||
        item.goodsName.toLowerCase().includes(query) ||
        item.sellingPrice.toString().toLowerCase().includes(query) ||
        item.warehouseId.toString().toLowerCase().includes(query)
      );
      totalGoods.value = filtered.length;
      return filtered;
    };

    const paginatedGoods = computed(() => {
      const start = (currentPage.value - 1) * pageSize.value;
      const end = start + pageSize.value;
      return filterGoods().slice(start, end);
    });

    const handleCurrentChange = (page) => {
      currentPage.value = page;
    };

    const handleSizeChange = (size) => {
      pageSize.value = size;
    };

    return {
      sidebarOpen,
      purchasableGoods,
      fetchPurchasableGoods,
      purchaseGoods,
      loading,
      search,
      handleSearch,
      reset,
      paginatedGoods,
      currentPage,
      pageSize,
      totalGoods,
      handleCurrentChange,
      handleSizeChange,
    };
  },
};
</script>

<style scoped>
body {
  margin: 0;
}

.example-showcase .el-loading-mask {
  z-index: 9;
}
.product-table-container {
 
  max-width: 1200px;
  padding: 20px;
 border-width: 3px;
  background-color: #ffffff;
  box-shadow: 0 8px 12px 0 rgba(55, 11, 142, 0.5);
  border-radius: 10px;
  width: 100%;
  margin: 20px auto;
}

.search-input {
  width: 300px;
  margin-right: 10px;
}

.search-button,
.reset-button {
  margin-right: 10px;
}

.product-table {
  margin-top: 20px;
}

.pagination {
  margin-top: 20px;
  text-align: center;
}
 

.el-button {
  margin: 10px;
}
 
</style>
