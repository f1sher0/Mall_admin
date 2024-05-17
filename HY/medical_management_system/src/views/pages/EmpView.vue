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
        <!-- 主页面 -->
        <el-main>
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item 
              >基础信息管理</el-breadcrumb-item
            >
            <el-breadcrumb-item>员工信息</el-breadcrumb-item>
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
              placeholder="请输入员工姓名..."
              v-model="form.name"
              @keyup.enter.native="loadPost"
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

          <!--弹出的编辑框Form -->

          <el-dialog title="员工信息" :visible.sync="dialogFormVisible">
            <el-form :model="form">
              <el-form-item label="员工id" :label-width="formLabelWidth">
                <el-input v-model="form.id" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="员工姓名" :label-width="formLabelWidth">
                <el-input v-model="form.name" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="部门" :label-width="formLabelWidth">
                <el-input v-model="form.dept" autocomplete="off"></el-input>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button type="primary" @click="save">确 定</el-button>
              <el-button @click="dialogFormVisible = false">取 消</el-button>
            </div>
          </el-dialog>
          <!--主页面表格显示员工信息-->
          <div>
            <el-table :data="tableData" style="width: 100%">
              <el-table-column prop="id" label="员工id" width="350">
              </el-table-column>
              <el-table-column prop="name" label="姓名" width="350">
              </el-table-column>
              <el-table-column prop="dept" label="部门" width="350">
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
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import Aside from "../../components/Aside.vue";
import Header from "../../components/Header.vue";
export default {
  name: "Emp",
  components: {
    Aside,
    Header,
  },
  data() {
    return {
      form: {
        id: "",
        name: "",
        dept: "",
      },
      dialogFormVisible: false,

      tableData: [
        // {
        //   id: "1",
        //   name: "王小虎",
        //   dept: "技术部",
        // },
        // {
        //   id: "2",
        //   name: "王小虎",
        //   dept: "市场部",
        // },
        // {
        //   id: "3",
        //   name: "王小虎",
        //   dept: "市场部",
        // },
        // {
        //   id: "4",
        //   name: "王小虎",
        //   dept: "广告部",
        // },
        // {
        //   id: "5",
        //   name: "王小虎",
        //   dept: "技术部",
        // },
        // {
        //   id: "6",
        //   name: "王小虎",
        //   dept: "市场部",
        // },
      ],
      pageSize: 5,
      pageNum: 1,
      total: 0,

      formLabelWidth: "120px",
    };
  },
  methods: {
    loadPost() {
      this.$axios
        .get(this.$httpUrl + "/emps/loadPost", {
          params: {
            backname: this.form.name,
            current: this.pageNum,
            size: this.pageSize,
          },
          Header:{
            Authorization:localStorage.getItem("JWTToken")
          }
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

    resetForm() {
      this.$refs.from.resetFields();
    },

    mod(row) {
      this.dialogFormVisible = true;
      //查询回显，赋值到表单
      this.form.id = row.id;

      this.form.name = row.name;
      this.form.dept = row.dept;
    },

    del(id) {
      this.$axios
        .get(this.$httpUrl + "/emps" + "/removeById?id=" + id, this.form)
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
        .post(this.$httpUrl + "/emps/save", this.form)
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

<style scope>
</style>