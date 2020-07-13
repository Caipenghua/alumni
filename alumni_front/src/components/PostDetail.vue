<template>
  <div>
    <el-form :model="list" :rules="rules" ref="posts" label-width="100px" class="demo-post">
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
        <el-button type="primary" @click="addComment">发表评论</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  data () {
    return {
      list: [],
      id: this.$route.params.postId,
      posts: {
        postTitle: '',
        postKeyWord: '',
        postPublishTime: '',
        postPublisher: '',
        postContent: ''
      }
    }
  },
  created () {
    this.$http.get('http://localhost:80/post/comment/' + this.$route.params.id).then(response => {
      // 注意： 通过 $http 获取到的数据，都在 result.body 中放着
      if (response.status === 200) {
        // 成功了
        this.mapData = response.body
        for (let key in response.body) {
          let value = response.body[ key ] // 注意是 [  ]

          alert(value) // 依次弹出小明、小花

          this.list = '[' + key + ']'
          this.posts = JSON.parse(this.list)
          alert(this.list)
          console.log(this.list)
        }
      } else {
        // 失败了
        alert('获取数据失败！')
      }
    })
  },
  methods: {

    addComment () {

    },
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
