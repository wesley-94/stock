const { defineConfig } = require('@vue/cli-service')

module.exports = defineConfig({
  outputDir: "../src/main/resources/static",
  devServer: {
    port: 3000,
    host: "localhost",
    proxy: {
      '/api': {
        // '/api' 로 들어오면 포트 8080(스프링 서버) 로 보낸다.
        target: 'http://localhost:8080',
        changeOrigin: true, // crossOrigin 허용
        secure: false
      }
    }
  },
  transpileDependencies: true,
  lintOnSave: false
});