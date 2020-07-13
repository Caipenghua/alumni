<template>
  <div>
    <el-form :model="posts" :rules="rules" ref="posts" label-width="100px" class="demo-post">
      <el-form-item label="贴子名称" prop="postTitle">
        <el-input v-model="posts.postTitle"></el-input>
      </el-form-item>
      <el-form-item label="贴子关键词" prop="postKeyWord">
        <el-input v-model="posts.postKeyWord"></el-input>
      </el-form-item>
      <el-form-item label="贴子时间" prop="postPublishTime">
        <el-date-picker v-model="posts.postPublishTime" type="datetime" placeholder="选择日期时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="贴子发布者" prop="postPublisher">
        <el-input v-model="posts.postPublisher"></el-input>
      </el-form-item>
      <el-form-item label="贴子内容" prop="postContent">
        <el-input type="textarea" v-model="posts.postContent"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="addPost('posts')">立即创建</el-button>
        <el-button @click="resetForm('posts')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  data () {
    return {
      posts: {
        postTitle: '',
        postKeyWord: '',
        postPublishTime: '',
        postPublisher: '',
        postContent: ''
      },
      rules: {
        postTitle: [
          { required: true, message: '请输入贴子名称', trigger: 'blur' },
          { min: 1, max: 10, message: '长度在 1 到 10 个字符', trigger: 'blur' }
        ],
        postPublishTime: [
          { type: 'date', required: true, message: '请选择日期及时间', trigger: 'change' }
        ],
        postPublisher: [
          { required: true, message: '请输入贴子发布者', trigger: 'change' }
        ],
        postContent: [
          { required: true, message: '请填写贴子内容', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    addPost (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$http
            .post('http://localhost:80/post',
              this.posts
              , {})
            .then(result => {
              if (result.status === 200) {
                alert('添加成功！')
                this.posts.postTitle = ''
                this.posts.postPublishTime = ''
                this.posts.postKeyWord = ''
                this.posts.postPublisher = ''
                this.posts.postContent = ''
                this.$router.push({path: '/'})
              } else {
                console.log('error submit!!')
                return false
              }
            })
        }
      })
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
    }
  }
}
</script>
