<template>
  <div class="dashboard-container">
  <el-container>
  <el-main>
    <el-carousel indicator-position="inside" height="500px">
      <el-carousel-item v-for="item in 4" :key="item" >
      </el-carousel-item>
    </el-carousel>
  </el-main>
</el-container>

<el-container>
    <el-main width="50px">
       <img :src="src1" />
  </el-main>
    <el-main>
       <img :src="src2" />
  </el-main>
</el-container>

<el-container>
    <el-main width="50px">
       <img :src="src3" />
  </el-main>
    <el-main>
       <img :src="src4" />
  </el-main>
</el-container>

<el-container>

</el-container>
  </div>
</template>

<script>

import image3 from '../../assets/images/ourProduction1.png'
import image2 from '../../assets/images/ourProduction2.png'
import image1 from '../../assets/images/ourProduction3.png'
import image4 from '../../assets/images/ourProduction4.png'
export default {
  name: 'Dashboard',
      data() {
      return {
        src1: image1,
        src2: image2,
        src3: image3,
        src4: image4,
      }
    }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.dashboard {
  &-container {
    margin: 0,
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}
</style>
<style>

  
  .el-carousel__item:nth-child(4n+1) {
	width: 100%;
  height: 100%;
	background-image: url(../../assets/images/1.png);
	background-size: cover; /* 使图片平铺满整个浏览器（从宽和高的最大需求方面来满足，会使某些部分无法显示在区域中） */
	position: absolute; /* 不可缺少 */
	/* overflow: hidden; */
	/* overflow: auto; */
	z-index: -1;
	background-repeat: no-repeat;
  }
  
  .el-carousel__item:nth-child(4n+2) {
	width: 100%;
  height: 100%;
	background-image: url(../../assets/images/3.png);
	background-size: cover; /* 使图片平铺满整个浏览器（从宽和高的最大需求方面来满足，会使某些部分无法显示在区域中） */
	position: absolute; /* 不可缺少 */
	/* overflow: hidden; */
	/* overflow: auto; */
	z-index: -1;
	background-repeat: no-repeat;
  }

  .el-carousel__item:nth-child(4n+3) {
	width: 100%;
  height: 100%;
	background-image: url(../../assets/images/4.png);
	background-size: cover; /* 使图片平铺满整个浏览器（从宽和高的最大需求方面来满足，会使某些部分无法显示在区域中） */
	position: absolute; /* 不可缺少 */
	/* overflow: hidden; */
	/* overflow: auto; */
	z-index: -1;
	background-repeat: no-repeat;
  }

  .el-carousel__item:nth-child(4n+4) {
	width: 100%;
  height: 100%;
	background-image: url(../../assets/images/6.png);
	background-size: cover; /* 使图片平铺满整个浏览器（从宽和高的最大需求方面来满足，会使某些部分无法显示在区域中） */
	position: absolute; /* 不可缺少 */
	/* overflow: hidden; */
	/* overflow: auto; */
	z-index: -1;
	background-repeat: no-repeat;
  }

</style>
