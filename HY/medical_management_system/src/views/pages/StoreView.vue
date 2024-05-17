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
          
            <el-breadcrumb-item>库房管理</el-breadcrumb-item>
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
            <el-input
              style="width: 260px"
              placeholder="请输入药名..."
              v-model="form.name"
            ></el-input>

            <el-button
              style="margin-left: 10px"
              type="primary"
              @click="loadPost"
              >搜 索</el-button
            >
            <el-button type="info" @click="reset">重 置</el-button>
            <!-- <el-button type="success" @click="add">新增入库登记</el-button> -->
            <el-button type="primary" @click="GetInExport"
              >导出库存报表</el-button
            >
          </div>

          <el-table :data="tableData" style="width: 100%">
            <!-- <el-table-column prop="id" label="药品id" width="180">
            </el-table-column> -->
            <!-- <el-table-column prop="typeNo" label="国药准字">
            </el-table-column> -->
            <el-table-column prop="name" label="药品名字"> </el-table-column>
            <!-- <el-table-column prop="supplierName" label="供应商">
            </el-table-column> -->
            <!-- <el-table-column prop="price" label="进货价"> </el-table-column> -->
            <el-table-column prop="count" label="数量"> </el-table-column>
            
            <!-- <el-table-column prop="time" label="入库时间"> </el-table-column> -->

            <!-- <el-table-column prop="selling" label="售价"> </el-table-column>
              <el-table-column prop="storageId" label="存储id"> </el-table-column> -->

            <!-- <el-table-column label="操作" width="180" align="center">
              <template slot-scope="scope">
                <el-button type="primary" @click="mod(scope.row)" size="mini"
                    >编辑</el-button
                  > 
                <el-popconfirm
                  style="margin-left: 10px"
                  confirm-button-text="确定"
                  cancel-button-text="我再想想"
                  icon="el-icon-info"
                  icon-color="red"
                  title="您确定退货吗？"
                  @confirm="del(scope.row.id)"
                >
                  <el-button
                    type="danger"
                    slot="reference"
                    size="mini"
                    @click="del"
                    >退货</el-button
                  >
                </el-popconfirm>
              </template>
            </el-table-column>-->
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

          <!-- 弹出的编辑框 -->
          <!--
          <el-dialog title="药品信息" :visible.sync="dialogFormVisible">
            <el-form :model="form" ref="form">
              <el-form-item
                label="药品id"
                :label-width="formLabelWidth"
                prop="id"
              >
                <el-input v-model="form.id" autocomplete="off"></el-input>
              </el-form-item>

              <el-form-item
                label="国药准字"
                :label-width="formLabelWidth"
                prop="type_no"
              >
                <el-input v-model="form.typeNo" autocomplete="off"></el-input>
              </el-form-item>

              <el-form-item
                label="药品名字"
                :label-width="formLabelWidth"
                prop="name"
              >
                <el-input v-model="form.name" autocomplete="off"></el-input>
              </el-form-item>

              <el-form-item
                label="供应商"
                :label-width="formLabelWidth"
                prop="supplierName"
              >
                <el-input
                  v-model="form.supplierName"
                  autocomplete="off"
                ></el-input>
              </el-form-item>

               <el-form-item
                label="进货价"
                :label-width="formLabelWidth"
                prop="price"
              >
                <el-input v-model="form.price" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item
                label="入库时间"
                :label-width="formLabelWidth"
                prop="time"
              >
                <el-date-picker
                  type="date"
                  placeholder="选择日期"
                  v-model="form.date1"
                  style="width: 100%"
                >
                </el-date-picker>
              </el-form-item> -->

              <!-- <el-form-item
                  label="售价"
                  :label-width="formLabelWidth"
                  prop="selling"
                >
                  <el-input v-model="form.selling" autocomplete="off"></el-input>
                </el-form-item>
  
                <el-form-item
                  label="存储id"
                  :label-width="formLabelWidth"
                  prop="storageId"
                >
                  <el-input
                    v-model="form.storageId"
                    autocomplete="off"
                  ></el-input>
                </el-form-item> 
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button type="primary" @click="save">确 定</el-button>
              <el-button @click="dialogFormVisible = false">取 消</el-button>
            </div>
          </el-dialog>-->
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
    
    <script>
import Aside from "../../components/Aside.vue";
import Header from "../../components/Header.vue";
export default {
  name: "store",
  //eslint-disable-next-line no-undef

  components: {
    Aside,
    Header,
  },
  data() {
    return {
      form: {
        //id: "",
       // typeNo: "",
        name: "",
       // supplierName: "",
        // price: "",
        number: "",
        //time: "",
        //selling: "",
        //storageId: "",
      },

      tableData: [
        // {
        //   //id: "1",
        //   typeNo: "12345678",
        //   name: "感冒药",
        //   supplierName: "修正药业",
        //   price: "24",
        //   number: "10",
        //   //time: "2023-08-08",
        //   //selling: "30",
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
        .get(this.$httpUrl + "/stores/loadPost", {
          params: {
            backname: this.form.name,
            current: this.pageNum,
            size: this.pageSize,
          },
        })
        .then((res) => res.data)
        .then((res) => {
          console.log(res);
          if (res.code == 200) {
            this.tableData = res.data.records;
            this.total = res.data.total;
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
    },
    GetInExport() {
      //库存报表导出函数
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
      this.form.number=row.number;z
      //this.form.price = row.price;
      //this.from.time = row.time;
      //this.form.selling = row.selling;
      //this.form.storageId = row.storageId;
    },

    del(id) {
      this.$axios
        .get(this.$httpUrl + "/store" + "/removeById?id=" + id, this.form)
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
        .post(this.$httpUrl + "/store/save", this.form)
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
        }).catch(error => {
   
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