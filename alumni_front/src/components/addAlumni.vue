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
        <el-button type="primary" @click="addAlumni()">立即添加</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  data () {
    return {
      Alumni: {
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
  methods: {
    addAlumni () {
      console.log(this.Alumni.alumniNumber)
      console.log(this.Alumni.alumniName)
      console.log(this.Alumni.alumniMotto)
      this.$http
        .post('http://localhost:80/insertAlumni',
          this.Alumni
          , { })
        .then(result => {
          if (result.status === 200) {
            alert('添加成功！')
            this.Alumni.alumniNumber = ''
            this.Alumni.alumniName = ''
            this.Alumni.alumniGender = ''
            this.Alumni.alumniGrade = ''
            this.Alumni.alumniMajor = ''
            this.Alumni.alumniCity = ''
            this.Alumni.alumniPhone = ''
            this.Alumni.alumniMail = ''
            this.Alumni.alumniCompany = ''
            this.Alumni.alumniMotto = ''
            this.$router.push({ path: '/' })
          } else {
            // 失败了
            alert('添加失败！')
          }
        })
    }
  }
}
</script>
