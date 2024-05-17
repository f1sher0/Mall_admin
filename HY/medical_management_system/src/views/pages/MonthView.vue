<template>
  <div>
    <el-container style="height: 700px; border: 1px solid #eee">
      <!-- 头部 -->
      <el-header><Header></Header></el-header>
      <el-container>
        <!-- 侧边栏 -->
        <el-aside width="200px">
          <span><Aside></Aside></span>
        </el-aside>

        <el-main>
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/index' }"
              >主页</el-breadcrumb-item
            >
            <el-breadcrumb-item>当月统计</el-breadcrumb-item>
          </el-breadcrumb>
          <div
            style="
              background-color: #409eff;
              height: 2px;
              text-align: center;
              margin-top: 10px;
              margin-bottom: 20px;
            "
          ></div>
          <div style="margin-bottom: 10px">
            <el-button type="primary" @click="GetInExport"
              >导出当月统计报表</el-button
            >
          </div>
          <el-table :data="statisticsData" style="width: 100%">
            <el-table-column prop="buyCount" label="进货交易次数">
            </el-table-column>
            <el-table-column prop="sucBuy" label="进货交易成功次数">
            </el-table-column>
            <el-table-column prop="totalExpenses" label="总进货额">
            </el-table-column>
            <el-table-column prop="salesCount" label="销售交易次数">
            </el-table-column>
            <el-table-column prop="sucSales" label="销售交易成功次数">
            </el-table-column>
            <el-table-column prop="totalRevenue" label="总销售额">
            </el-table-column>
            <el-table-column prop="totalProfit" label="总利润">
            </el-table-column>
          </el-table>
<br>
          <el-table :data="tableData" style="width: 100%">
            <el-table-column
              prop="id"
              label="药品id"
              width="180"
            ></el-table-column>
            <el-table-column prop="typeNo" label="国药准字"> </el-table-column>
            <el-table-column prop="name" label="药品名字"> </el-table-column>
            <el-table-column prop="price" label="进货价"> </el-table-column>
            <el-table-column prop="selling" label="售价"> </el-table-column>
            <el-table-column prop="time" label="时间"> </el-table-column>
            <el-table-column prop="flag" label="类型">
              <template slot-scope="scope">
                <el-tag
                  :type="scope.row.flag == 1 ? 'primary' : 'success'"
                  disable-transitions
                  >{{ scope.row.flag == 1 ? "已售" : "进货" }}</el-tag
                >
              </template>
            </el-table-column>
          </el-table>
          <!-- 分页栏 -->
          <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="pageNum"
            :page-sizes="[5, 10, 15, 20]"
            :page-size="pageSize"
            layout="total, sizes, prev, pager, next, jumper"
            :total="total"
          >
          </el-pagination>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
        
        <script>
import Aside from "../../components/Aside.vue";
import Header from "../../components/Header.vue";
export default {
  name: "month",
  //eslint-disable-next-line no-undef

  components: {
    Aside,
    Header,
  },
  data() {
    return {
      form: {
        id: "",
        typeNo: "",
        name: "",
        //supplierName: "",
        //number: "",
        price: "",
        selling: "",
        time: "",
        //storageId: "",
        flag: "",
      },
      statisticsData: [
        // {
        //   // buyCount: "10",
        //   // sucBuy: "9",
        //   // totalExpenses: "216",
        //   // salesCount: "11",
        //   // sucSales: "10",
        //   // totalRevenue: "250",
        //   // totalProfit: "34",
        // },
      ],
      tableData: [
        // {
        //   id: "1",
        //   typeNo: "12345678",
        //   name: "感冒药",
        //   //supplierName: "修正药业",
        //   price: "24",
        //   //number: "10",
        //   selling: "30",
        //   time: "2023-08-08",
        //   flag: "1",
        //   //storageId: "1",
        // },
        // {
        //   id: "2",
        //   typeNo: "12345679",
        //   name: "蓝瓶钙",
        //   //supplierName: "修正药业",
        //   price: "24",
        //   //number: "10",
        //   selling: "30",
        //   time: "2023-08-08",
        //   state: "0",
        //   //storageId: "1",
        // },
      ],
      pageSize: 5,
      pageNum: 1,
      total: 0,
      dialogFormVisible: false,
    };
  },

  methods: {
    loadPost() {
      this.$axios
        .get(this.$httpUrl + "/stores/monthRecord", {
          // params: {
          //   name: this.name,
          //   current: this.pageNum,
          //   size: this.pageSize,
          // },
        })
        .then((res) => res.data)
        .then((res) => {
          console.log(res);
          if (res.code == 200) {
            // this.tableData = res.data.records;
            this.statisticsData=res.data.records;
            // this.total = res.data.total;
          } else {
            alert("获取数据失败");
          }
        }).catch(error => {
          if (error.response && error.response.status === 401) { // 检查状态码
            alert("JWTtoken验证失败，重新登录");
                    // 如果返回的是401 Unauthorized，则跳转到登录页面
        this.$router.replace('/login');
      }
  });
        
  this.$axios
        .get(this.$httpUrl + "/stores/monthfortableData", {
          params: {
            // medicineName: this.name,
            current: this.pageNum,
            size: this.pageSize,
          },
        })
        .then((res) => res.data)
        .then((res) => {
          console.log(res);
          if (res.code == 200) {
        
            this.tableData = res.data.records  ;
            // this.statisticsData = res.data.data;
            
            // alert(res.data.data);
            console.log(JSON.stringify(res.data));

            this.total = res.data.total;
          } else {
            alert("获取数据失败");
          }
          });
    },
    GetInExport() {
      //入库报表导出函数
      this.$axios
        .get("http://localhost:5052/stores/monthExport", {
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
          const fileName = "当月统计报表.xlsx";
          link.download = fileName;

          // 模拟点击下载链接
          link.click();

          // 释放链接占用的资源
          URL.revokeObjectURL(link.href);
        })
        .catch((error) => {
          console.error("导出失败", error);
        });
    },
    resetForm() {
      this.$refs.from.resetFields();
    },

    mod(row) {
      this.dialogFormVisible = true;
      //查询回显，赋值到表单
      //this.form.id = row.id;
      this.form.typeNo = row.typeNo;
      this.form.name = row.name;
      this.form.supplierName = row.supplierName;
      this.form.number = row.number;
      //this.form.price = row.price;
      //this.from.time = row.time;
      //   this.form.selling = row.selling;
      //   this.form.storageId = row.storageId;
    },

    del(id) {
      this.$axios
        .get(this.$httpUrl + "/month" + "/removeById?id=" + id, this.form)
        .then((res) => res.data)
        .then((res) => {
          console.log(res);
          if (res.code == 200) {
            alert("删除成功");
            this.dialogFormVisible = false;
            this.loadPost();
          } else {
            alert("获取数据失败");
          }
        });
    },

    add() {
      this.dialogFormVisible = true;
      this.$nextTick(() => {
        this.resetForm();
      });
    },

    save() {
      this.$axios
        .post(this.$httpUrl + "/month/save", this.form)
        .then((res) => res.data)
        .then((res) => {
          console.log(res);
          if (res.code == 200) {
            alert("保存成功");
            this.dialogFormVisible = false;
            this.loadPost();
          } else {
            alert("获取数据失败");
          }
        });
    },

    reset() {
      this.form.name = "";
      this.loadPost();
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.pageNum = val;
      this.loadPost();

    },
    handleSizeChange(val){
      this.pageSize=val;
      this.loadPost();
    },
  }, //methods的结尾

  beforeMount() {
    this.loadPost();
  },
};
</script>

<style scoped>

</style>