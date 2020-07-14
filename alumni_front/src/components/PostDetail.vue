<template>
  <div>
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span v-text="posts.postTitle"></span>
        <br/><br/>
        <span>发布时间：</span>
        <el-date-picker v-model="posts.postPublishTime" type="datetime" placeholder="选择日期时间" readonly>
        </el-date-picker>
        <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
      </div>
      <el-radio-group v-model="labelPosition" size="small">
        <el-radio-button label="left">左对齐</el-radio-button>
        <el-radio-button label="right">右对齐</el-radio-button>
        <el-radio-button label="top">顶部对齐</el-radio-button>
      </el-radio-group>
      <el-form :label-position="labelPosition"  :model="posts" :rules="rules" ref="posts" label-width="100px" class="demo-post">
        <el-form-item label="贴子关键词" prop="postKeyWord" align="left">
          <span v-text="posts.postKeyWord"></span>
        </el-form-item>
        <el-form-item label="贴子发布者" prop="postPublisher" align="left">
          <span v-text="posts.postPublisher"></span>
        </el-form-item>
        <el-form-item label="贴子内容" prop="postContent">
          <el-input autosize type="textarea" v-model="posts.postContent" readonly></el-input>
        </el-form-item>
        <el-form-item>
          <el-badge :value="12" class="item">
            <el-button size="small">评论</el-button>
          </el-badge>
          <el-badge :value="3" class="item">
            <el-button size="small">回复</el-button>
          </el-badge>
          <el-badge :value="1" class="item" type="primary">
            <el-button size="small">评论</el-button>
          </el-badge>
          <el-badge :value="2" class="item" type="warning">
            <el-button size="small">回复</el-button>
          </el-badge>
          <el-dropdown trigger="click">
  <span class="el-dropdown-link">
    点我查看<i class="el-icon-caret-bottom el-icon--right"></i>
  </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item class="clearfix">
                评论
                <el-badge class="mark" :value="12" />
              </el-dropdown-item>
              <el-dropdown-item class="clearfix">
                回复
                <el-badge class="mark" :value="3" />
              </el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-form-item>
      </el-form>
      <el-button type="primary" @click="addComment">发表评论</el-button>
      <router-link to="/Post">
        <el-button type="success" icon="el-icon-circle-plus-outline" size="large" round>返回论坛</el-button>
      </router-link>
    </el-card>
  </div>
</template>
<script>
export default {
  data () {
    return {
      labelPosition: 'left',
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
        this.posts = response.body
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
<style>
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .box-card {

  }
  .item {
    margin-top: 10px;
    margin-right: 40px;
  }
</style>
