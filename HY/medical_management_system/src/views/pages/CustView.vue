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
            <el-breadcrumb-item 
              >基础信息管理</el-breadcrumb-item
            >
            <el-breadcrumb-item>客户信息</el-breadcrumb-item>
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
              placeholder="请输入客户姓名..."
              v-model="form.name"
            ></el-input>

            <el-button
              style="margin-left: 10px"
              type="primary"
              @click="loadPost"
              >搜 索</el-button
            >
            <el-button type="info" @click="reset">重 置</el-button>
            <el-button type="success" @click="add">新 增</el-button>
          </div>

          <!-- 主要的表格 -->
          <div>
            <el-table :data="tableData" style="width: 100%">
              <el-table-column prop="id" label="客户id" width="300">
              </el-table-column>

              <el-table-column prop="name" label="客户姓名" width="300">
              </el-table-column>
              <el-table-column prop="phone" label="客户联系方式" width="300">
              </el-table-column>
             
              <el-table-column label="操作" align="center">
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
                    title="您确定删除吗？"
                    @confirm="del(scope.row.id)"
                  >
                    <el-button
                      type="danger"
                      slot="reference"
                      size="mini"
                 
                      >删除</el-button
                    >
                  </el-popconfirm>
                </template>
              </el-table-column>
            </el-table>
            <br />
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
          </div>
          <!--弹出的编辑框Form -->

          <el-dialog title="客户信息" :visible.sync="dialogFormVisible">
            <el-form :model="form">
                <el-form-item label="客户id" :label-width="formLabelWidth">
                <el-input v-model="form.id" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="客户姓名" :label-width="formLabelWidth">
                <el-input v-model="form.name" autocomplete="off"></el-input>
              </el-form-item>

              <el-form-item label="客户联系方式" :label-width="formLabelWidth">
                <el-input v-model="form.phone" autocomplete="off"></el-input>
              </el-form-item>
              <!-- <el-form-item label="客户订单号" :label-width="formLabelWidth">
                <el-input v-model="form.saleNo" autocomplete="off"></el-input>
              </el-form-item> -->
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button type="primary" @click="save">确 定</el-button>
              <el-button @click="dialogFormVisible = false">取 消</el-button>
            </div>
          </el-dialog>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
  
  <script>
import Aside from "../../components/Aside.vue";
import Header from "../../components/Header.vue";
export default {
  name: "Cust",
  components: {
    Aside,
    Header,
  },
  data() {
    return {
      form: {
        id: "",
        name: "",
        phone:"",
      },
      
      tableData: [
        // {
        //   id: "1",
        //   name: "马化腾",
        // },
      ],
      dialogFormVisible: false,
      pageSize: 5,
      pageNum: 1,
      total: 0,
      formLabelWidth: "120px",
    };
  }, //data结束

  methods: {
    loadPost() {
      this.$axios
        .get(this.$httpUrl + "/customers/loadPost", {
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
          }else if(res.code == 401) {
            alert("View 用户JWT令牌验证失败,请重新登录");
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

    resetForm() {//清空from表单内容
      this.$refs.from.resetFields();
    },

    mod(row) {
      //编辑函数
      this.dialogFormVisible = true;
      //查询回显，赋值到表单
      this.form.id = row.id;
      this.form.name = row.name;
    },

    del(id) {
      //删除函数
      this.$axios
        .get(this.$httpUrl + "/customers" + "/removeById?id=" + id, this.form)
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
      //新增函数
      this.dialogFormVisible = true;
      this.$nextTick(() => {
        this.resetForm();
      });
    },

    save() {
      //保存函数
      this.$axios
        .post(this.$httpUrl + "/customers/save", this.form)
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
    onsubmit: function () {
      alert("提交成功");
    },
  }, //methods的结尾 

  beforeMount() {
    this.loadPost();
  },
};
</script>
  
  <style scoped>
</style>