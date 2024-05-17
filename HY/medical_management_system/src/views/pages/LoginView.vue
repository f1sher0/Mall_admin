<template>
    <div class="loginBody">
        <div class="loginDiv">
            <div class="login-content">
                <h1 class="login-title">用户登录</h1>
                <el-form :model="loginForm" label-width="100px"
                         :rules="rules" ref="loginForm">
                    <el-form-item label="用户名" prop="name">
                        <el-input style="width: 240px" type="text" v-model="loginForm.name"
                                  autocomplete="off" size="small"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="password">
                        <el-input style="width: 240px" type="password" v-model="loginForm.password"
                                  show-password autocomplete="off" size="small" @keyup.enter.native="confirm"></el-input>
                 
                                </el-form-item>
                    <el-form-item>
                        <el-button type="primary " plain @click="confirm" :disabled="confirm_disabled">确 定</el-button>
                        <el-button type="success" plain @click="beforregister"  >注册</el-button>
                        <el-button type="info  " plain  @click="reset"   >重 置</el-button>

                    </el-form-item>
                </el-form>
                <!-- //注册时的编辑框 -->
          <el-dialog title="员工信息" :visible.sync="dialogFormVisible">
            <el-form :model="form" ref="form" :inline="true">
              <el-form-item label="员工id" :label-width="formLabelWidth">
                <el-input v-model="form.id" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="员工姓名" :label-width="formLabelWidth">
                <el-input v-model="form.name" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="部门" :label-width="formLabelWidth">
                <el-input v-model="form.dept" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="员工密码" :label-width="formLabelWidth">
                <el-input v-model="form.password" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="部门id" :label-width="formLabelWidth">
                <el-input v-model="form.manageId" autocomplete="off"></el-input>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button type="primary" @click="register">确 定</el-button>
              <el-button @click="dialogFormVisible = false">取 消</el-button>
            </div>
          </el-dialog>
            </div>
        </div>
    </div>
</template>


<script>
    export default {
        name: "Login",
        data(){
        
            return{
                confirm_disabled:false,
                dialogFormVisible:false,
                form: {
        id: "",
        name: "",
        dept: "",
        manageId:"",
        password:""
      },
                loginForm:{
                    name:'',
                    password:''
                },
                rules:{
                    no: [
                        { required: true, message: '请输入用户名', trigger: 'blur' }
                    ],
                    password: [
                        { required: true, message: '请输密码', trigger: 'blur' }
                    ],
                }
            }
        },
        methods:{

            confirm(){
                this.confirm_disabled=true;
                this.$refs.loginForm.validate((valid) => {
                    if (valid) { //valid成功为true，失败为false
                        //去后台验证用户名密码
                        this.$axios.post(this.$httpUrl+'/emps/user/login',this.loginForm).then(res=>res.data).then(res=>{
                            console.log(res)
                            if(res.code==200){
                                // alert(res.data.name);
                                sessionStorage.setItem("CurUser",JSON.stringify(res.data.user.name))
                                sessionStorage.setItem("CurUserId",JSON.stringify(res.data.user.id))
                                localStorage.setItem("JWTToken", res.data.JWTtoken);
                                alert(  localStorage.getItem("JWTToken"));
                                alert("登录成功");  this.$router.replace('/index');
                   
                            }else{
                                this.confirm_disabled=false;
                                alert(res.msg);
                                return false;
                            }
                        });
                    } else {
                        this.confirm_disabled=false;
                        console.log('校验失败');
                    

                        return false;
                    }
                }).catch(error => {
          if (error.response && error.response.status === 401) { // 检查状态码
            alert("JWTtoken验证失败，重新登录");
                    // 如果返回的是401 Unauthorized，则跳转到登录页面
        this.$router.replace('/login');
      }
   
  });

            },
            reset(){
                    this.loginForm.name="";
                    this.loginForm.password="";

            },
            beforregister(){
                this.dialogFormVisible = true;
      this.$nextTick(() => {
        this.resetForm();  this.register();  
      });
       
    },
            register() {
              
                this.$axios
        .post( this.$httpUrl+"/emps/user/register",  this.form)
        .then((res) => res.data)
        .then((res) => {
          console.log(res);
          if (res.code == 200) {
            //  alert("注册成功");
            alert(res.msg);
          
           this.dialogFormVisible=false;
          } else {
            // alert("注册失败，请考虑是否已有账号");
          
            alert(res.msg);
            
            this.dialogFormVisible=false;

        }
        }).catch(error => {
   
});
      
    }

        }
    }
</script>

<style scoped>
    .loginBody {
        position: absolute;
        width: 100%;
        height: 100%;
        background-color: #B3C0D1;
    }
    .loginDiv {
        position: absolute;
        top: 50%;
        left: 50%;
        margin-top: -200px;
        margin-left: -250px;
        width: 450px;
        height: 330px;
        background: #fff;
        border-radius: 5%;

    }
    .login-title {
        margin: 20px 0;
        text-align: center;
    }
    .login-content {
        width: 400px;
        height: 250px;
        position: absolute;
        top: 25px;
        left: 25px;
    }
</style>