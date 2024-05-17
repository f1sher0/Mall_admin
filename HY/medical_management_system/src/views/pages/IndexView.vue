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
          <h2>欢迎使用医药销售管理系统</h2>
             <p>  {{ greeting }} {{ currentUser }}</p>
              <!-- ：{{ currentUser.name }} -->
          <el-button type="primary" @click="backup"
            >数据备份</el-button
          >
          <el-button type="primary" @click="recover"
            >数据恢复</el-button
          >
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import Aside from "../../components/Aside.vue";
import Header from "../../components/Header.vue";
export default {
  name: "Index",
  components: {
    Aside,
    Header,
  },
  computed: {
    greeting() {
      const hour = new Date().getHours();
      if (hour >= 0 && hour < 12) {
        return "上午好";
      } else if (hour >= 12 && hour < 18) {
        return "下午好";
      } else {
        return "晚上好";
      }
    },
    currentUser() {
      const curUser = sessionStorage.getItem("CurUser");
      if (curUser) {
        return JSON.parse(curUser);
      }
      alert("JWTtoken验证失败，重新登录");
                   
        this.$router.replace('/login');
      return "未登录"; // Handle the case where user is not logged in
    },
  },
  methods: {

  backup() {
    this.$axios
      .get(this.$httpUrl + "/database/backup", {
    
      })
      .then((res) => res.data)
      .then((res) => {
        console.log(res);
        if (res.code == 200) {
      alert("备份成功,sql请于后端项目resources mybackup查看")
        } else {
          alert("备份数据失败");
        }
      });
  },

  
  

  recover() {
    this.$axios
      .post(this.$httpUrl + "/database/restore",  )
      .then((res) => res.data)
      .then((res) => {
        console.log(res);
        if (res.code == 200) {
          alert("数据恢复成功");
        
        } else {
          alert("数据恢复失败");
        }
      }).catch(error => {
   
  });
  },
 
 
}, //methods的结尾
};
</script>

 