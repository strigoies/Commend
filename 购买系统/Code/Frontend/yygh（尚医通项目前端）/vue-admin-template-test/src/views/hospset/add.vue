<template>
  <div class="app-container">
    保险设置添加
    <el-form label-width="120px">
      <el-form-item label="保险名称">
        <el-input v-model="hospitalSet.hosname" />
      </el-form-item>
      <el-form-item label="保险编号">
        <el-input v-model="hospitalSet.hoscode" />
      </el-form-item>
      <el-form-item label="保障项目">
        <el-input v-model="hospitalSet.apiUrl" />
      </el-form-item>
      <el-form-item label="联系人姓名">
        <el-input v-model="hospitalSet.contactsName" />
      </el-form-item>
      <el-form-item label="联系人手机">
        <el-input v-model="hospitalSet.contactsPhone" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="saveOrUpdate">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import hospset from "@/api/hospset";
export default {
  data() {
    return {
      hospitalSet: {},
    };
  },
  created() {
    //获取路由id值
    //调用接口得到医院设置信息
    if (this.$route.params && this.$route.params.id) {
      const id = this.$route.params.id;
      this.getHostSet(id);
    } else {
      this.hospitalSet = {};
    }
  },
  methods: {
    //添加
    save() {
      hospset.saveHospSet(this.hospitalSet).then((response) => {
        //提示信息
        this.$message({
          type: "success",
          message: "添加成功!",
        });
        //跳转页面，使用路由跳转
        this.$router.push({ path: "/hospSet/list" });
      });
    },
    //修改
    update() {
      hospset.updateHospSet(this.hospitalSet).then((response) => {
        //提示信息
        this.$message({
          type: "success",
          message: "修改成功!",
        });
        //跳转页面，使用路由跳转
        this.$router.push({ path: "/hospSet/list" });
      });
    },

    saveOrUpdate() {
      //判断添加还是修改
      if (!this.hospitalSet.id) {
        // 没有id，就是添加
        this.save();
      } else {
        //有id，做修改
        this.update();
      }
    },
    //根据id查询
    getHostSet(id) {
      hospset.getHospSet(id).then((response) => {
        this.hospitalSet = response.data;
      });
    },
  },
};
</script>