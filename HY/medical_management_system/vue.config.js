const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  //关闭eslint校验
  lintOnSave: false,
  devServer: {
		proxy: {
			'': {
				target: 'http://localhost:5052/', //此处输入你后端的地址
				changeOrigin: true,
				pathRewrite: {}
			}
		}
	}
})
 