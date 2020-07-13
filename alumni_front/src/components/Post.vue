<template>
  <el-container>
    <el-header>
      <router-link to="/">
        <el-button type="success" icon="el-icon-circle-plus-outline" size="large" round>校友录</el-button>
      </router-link>
      <p>校友录论坛</p>
    </el-header>
    <el-main>
      <!--新增按钮-->
      <el-col :span="2" class="grid">
        <router-link to="/addPost">
          <el-button type="success" icon="el-icon-circle-plus-outline" size="large" round>新增</el-button>
        </router-link>
      </el-col>
      <el-table stripe ref="multipleTable" :data="list.filter(data => !search || data.postTitle.toLowerCase().includes(search.toLowerCase()))" style="width: 100%" :default-sort = "{prop: 'id', order: 'descending'}" max-height="550" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55">
        </el-table-column>
        <el-table-column fixed prop="postId" label="贴子id" sortable width="50">
        </el-table-column>
        <el-table-column fixed prop="postTitle" label="贴子名称" sortable width="180" column-key="postId">
        </el-table-column>
        <el-table-column prop="postKeyWord" label="贴子关键词" sortable width="110">
        </el-table-column>
        <el-table-column prop="postPublishTime" label="贴子时间" type="datetime" :formatter="formatDate" width="100">
        </el-table-column>
        <el-table-column prop="postPublisher" label="贴子发布者" sortable width="110">
        </el-table-column>
        <el-table-column prop="postContent" label="贴子内容" width="110">
        </el-table-column>
        <el-table-column
          align="right">
          <template slot="header" slot-scope="scope">
            <el-input
              v-model="search"
              size="mini"
              placeholder="输入关键字搜索"/>
          </template>
          <template slot-scope="scope">
            <el-button
              size="mini"
              @click="updateAlumni(scope.$index, scope.row)">评论</el-button>
            <el-button
              size="mini"
              type="danger"
              @click.native.prevent="viewDetail(scope.$index, scope.row)">查看贴子</el-button>
            <el-button size="mini" @click="toggleSelection(scope.row)">选择该行</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-main>
    <el-footer>作者：张翛然</el-footer>
  </el-container>
</template>

<script>
export default {
  created () {
    this.listAllAlumni()
  },
  data () {
    return {
      // 查询输入框数据
      input: 0,
      list: [], // 存放列表数据
      search: '',
      multipleSelection: []
    }
  },
  methods: {
    formatDate (row, column) {
      let date = new Date(parseInt(row.postPublishTime))
      let Y = date.getFullYear() + '-'
      let M = date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) + '-' : date.getMonth() + 1 + '-'
      let D = date.getDate() < 10 ? '0' + date.getDate() + ' ' : date.getDate() + ' '
      let h = date.getHours() < 10 ? '0' + date.getHours() + ':' : date.getHours() + ':'
      let m = date.getMinutes() < 10 ? '0' + date.getMinutes() + ':' : date.getMinutes() + ':'
      let s = date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds()
      return Y + M + D + h + m + s
    },
    listAllAlumni () {
      // 由于已经导入了 Vue-resource这个包，所以 ，可以直接通过  this.$http 来发起数据请求
      this.$http.get('http://localhost:80/post/list').then(response => {
        console.log(response)
        this.list = response.body
      }, function (err) {
        console.log(err)
      })
    },
    viewDetail (index, row) {
      this.$router.push({
        path: `/postDetail/${row.postId}`
      })
    },
    updateAlumni (index, row) {
      this.$router.push({
        path: `/updateAlumni/${row.alumniNumber}`
      })
    },
    deleteAlumni (index, row) {
      this.$http.delete('http://localhost:80/deleteAlumniById/' + row.alumniNumber).then(response => {
        if (response.status === 200) {
          // 删除成功
          this.listAllAlumni()
        } else {
          alert('删除失败！')
        }
      })
    },
    toggleSelection (row) {
      this.$refs.multipleTable.toggleRowSelection(row)
    },
    handleSelectionChange (val) {
      this.multipleSelection = val
    },
    indexMethod (index) {
      return index * 1
    },
    filterGender (value, row) {
      return row.gender === value
    },
    filterHandler (value, row, column) {
      const property = column['property']
      return row[property].substring(0, 7) === value
    }
  }
}
</script>
<style>

</style>
