<template>
  <el-menu :default-openeds="['1', '3']"
  style="height: 100%;">
    <el-submenu index="0">
      <template slot="title"
        ><i class="el-icon-house"></i
        ><router-link to="/index" class="link">主页</router-link></template
      >
      <el-menu-item index="0-1">
        <router-link to="/today" class="link">当日统计</router-link></el-menu-item
      >
      <el-menu-item index="0-2">
        <router-link to="/month" class="link">当月统计</router-link></el-menu-item
      >
    </el-submenu>

    <el-submenu index="1">
      <template slot="title"
        ><i class="el-icon-message"></i>基础信息管理</template
      >
      <el-menu-item index="1-1">
        <router-link to="/med" class="link">药品信息</router-link></el-menu-item
      >
      <el-menu-item index="1-2">
        <router-link to="/emp" class="link">员工信息</router-link></el-menu-item
      >
      <el-menu-item index="1-3">
        <router-link to="/cust" class="link">客户信息</router-link></el-menu-item
      >
      <el-menu-item index="1-4">
        <router-link to="/supp" class="link">供应商信息</router-link></el-menu-item
      >
    </el-submenu>

    <el-menu-item index="2">
      <template slot="title"><i class="el-icon-right"></i><router-link to="/outIns" class="link">进货管理</router-link></template>
    </el-menu-item>

    <el-menu-item index="3">
      <template slot="title"><i class="el-icon-box"></i><router-link to="/store" class="link">库房管理</router-link></template>
    </el-menu-item>

    <el-menu-item index="4">
      <template slot="title"><i class="el-icon-sell"></i><router-link to="/sale" class="link">销售管理</router-link></template>
    </el-menu-item>

  </el-menu>
</template>

<script>
export default {
  name: "Aside",
};
</script>

<style scoped>
.link {
  text-decoration: none;
}
.link:visited {
  color: black;
}
</style>