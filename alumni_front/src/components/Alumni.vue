<template>
  <el-container>
    <el-header>
      <router-link to="/Post">
        <el-button type="success" icon="el-icon-circle-plus-outline" size="large" round>论坛</el-button>
      </router-link>
      <p>校友录</p></el-header>
    <el-main>
      <!--新增按钮-->
      <el-col :span="2" class="grid">
        <router-link to="/addAlumni">
          <el-button type="success" icon="el-icon-circle-plus-outline" size="large" round>新增</el-button>
        </router-link>
      </el-col>
      <el-table  stripe ref="multipleTable" :data="list.filter(data => !search || data.alumniName.toLowerCase().includes(search.toLowerCase())||data.alumniNumber.toLowerCase().includes(search.toLowerCase())||data.alumniGrade.toLowerCase().includes(search.toLowerCase())||data.alumniMajor.toLowerCase().includes(search.toLowerCase())||data.alumniCity.toLowerCase().includes(search.toLowerCase())||data.alumniCompany.toLowerCase().includes(search.toLowerCase()))" style="width: 100%" :default-sort = "{prop: 'id', order: 'descending'}" max-height="550" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55">
        </el-table-column>
        <el-table-column fixed prop="alumniNumber" label="学号" sortable width="180" column-key="alumni_number"
                         :filters="[{text: '2016级', value: '2432016'}, {text: '2017级', value: '2432017'}, {text: '2018级', value: '2432018'}, {text: '2019级', value: '2432019'}]"
                         :filter-method="filterHandler">
        </el-table-column>
        <el-table-column prop="alumniName" label="姓名" sortable width="110">
        </el-table-column>
        <el-table-column prop="alumniGender" label="性别" width="100"
                         :filters="[{ text: '男', value: '男' }, { text: '女', value: '女' }]"
                         :filter-method="filterGender"
                         filter-placement="bottom-end">
          <template slot-scope="scope">
            <el-tag
              :type="scope.row.alumniGender === '男' ? 'primary' : 'success'"
              disable-transitions>{{scope.row.alumniGender}}</el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="alumniGrade" label="年纪" sortable width="110">
        </el-table-column>
        <el-table-column prop="alumniMajor" label="专业'" sortable width="110">
        </el-table-column>
        <el-table-column prop="alumniCity" label="所在城市" sortable width="110">
        </el-table-column>

        <el-table-column prop="alumniPhone" label="联系电话" width="110">
        </el-table-column>
        <el-table-column prop="alumniMail" label="邮件" width="160">
        </el-table-column>
        <el-table-column prop="alumniCompany" label="所在公司" width="110">
        </el-table-column>
        <el-table-column prop="alumniMotto" label="自我介绍" width="110">
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
            <el-button size="mini" @click="toggleSelection(scope.row)">选择</el-button>
            <el-button size="mini" @click="updateAlumni(scope.$index, scope.row)">修改</el-button>
            <el-button size="mini" type="danger" @click.native.prevent="deleteAlumni(scope.$index, scope.row)">删除</el-button>
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
    listAllAlumni () {
      // 由于已经导入了 Vue-resource这个包，所以 ，可以直接通过  this.$http 来发起数据请求
      this.$http.get('http://localhost:80/getAllAlumni').then(response => {
        console.log(response)
        this.list = response.body
      }, function (err) {
        console.log(err)
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
      return row.alumniGender === value
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
