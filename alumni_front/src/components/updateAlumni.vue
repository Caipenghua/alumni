<template>
  <div>
    <el-form ref="form" label-width="80px">
      <el-form-item label="学号">
        <el-input v-model="Alumni.alumniNumber"></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="Alumni.alumniName"></el-input>
      </el-form-item>
      <el-form-item label="性别" align="left">
        <el-select v-model="Alumni.alumniGender" placeholder="请选择">
          <el-option label="男" value="男"></el-option>
          <el-option label="女" value="女"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="年纪">
        <el-input v-model="Alumni.alumniGrade"></el-input>
      </el-form-item>
      <el-form-item label="专业">
        <el-input v-model="Alumni.alumniMajor"></el-input>
      </el-form-item>
      <el-form-item label="所在城市">
        <el-input v-model="Alumni.alumniCity"></el-input>
      </el-form-item>
      <el-form-item label="联系电话">
        <el-input v-model="Alumni.alumniPhone"></el-input>
      </el-form-item>
      <el-form-item label="邮件">
        <el-input v-model="Alumni.alumniMail"></el-input>
      </el-form-item>
      <el-form-item label="所在公司">
        <el-input v-model="Alumni.alumniCompany"></el-input>
      </el-form-item>
      <el-form-item label="自我介绍">
        <el-input v-model="Alumni.alumniMotto"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="confirmUpdateAlumni()">立即修改</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  data () {
    return {
      Alumni: {
        id: this.$route.params.alumniNumber,
        alumniNumber: '',
        alumniName: '',
        alumniGender: '',
        alumniGrade: '',
        alumniMajor: '',
        alumniCity: '',
        alumniPhone: '',
        alumniMail: '',
        alumniCompany: '',
        alumniMotto: ''
      }
    }
  },
  created () {
    this.$http.get('http://localhost:80/getAlumniById/' + this.$route.params.id).then(response => {
      // 注意： 通过 $http 获取到的数据，都在 result.body 中放着
      this.Alumni = response.body
      if (response.status === 200) {
        // 成功了
        this.Alumni = response.body
      } else {
        // 失败了
        alert('获取数据失败！')
      }
    })
  },
  methods: {
    confirmUpdateAlumni () {
      this.$http
        .put('http://localhost:80/updateAlumni', this.Alumni, {})
        .then(response => {
          if (response.status === 200) {
            alert('修改成功！')
            this.$router.push({ path: '/' })
          } else {
            // 失败了
            alert('修改失败！')
          }
        })
    }
  }
}
</script>
