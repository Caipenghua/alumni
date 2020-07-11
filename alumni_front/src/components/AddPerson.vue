<template>
  <div>
    <el-form ref="form" label-width="80px">
      <el-form-item label="学号">
        <el-input v-model="Person.num"></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="Person.name"></el-input>
      </el-form-item>
      <el-form-item label="部门">
        <el-input v-model="Person.dept"></el-input>
      </el-form-item>
      <el-form-item label="性别" align="left">
        <el-select v-model="Person.gender" placeholder="请选择">
          <el-option label="男" value="男"></el-option>
          <el-option label="女" value="女"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="电话">
        <el-input v-model="Person.phone"></el-input>
      </el-form-item>
      <el-form-item label="邮件">
        <el-input v-model="Person.email"></el-input>
      </el-form-item>
      <el-form-item label="座右铭">
        <el-input v-model="Person.motto"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="addPerson()">立即添加</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  data () {
    return {
      Person: {
        num: '',
        name: '',
        dept: '',
        gender: '',
        phone: '',
        email: '',
        motto: ''
      }
    }
  },
  methods: {
    addPerson () {
      console.log(this.Person.num)
      console.log(this.Person.name)
      console.log(this.Person.phone)
      this.$http
        .post('http://localhost:80/insertPerson',
          this.Person
          , { })
        .then(result => {
          if (result.status === 200) {
            alert('添加成功！')
            this.Person.num = ''
            this.Person.name = ''
            this.Person.dept = ''
            this.Person.gender = ''
            this.Person.phone = ''
            this.Person.email = ''
            this.Person.motto = ''
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
