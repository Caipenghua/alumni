<template>
  <el-container>
    <el-header><p>校友录</p></el-header>
    <el-main>
      <!--新增按钮-->
      <el-col :span="2" class="grid">
        <router-link to="/addAlumni">
          <el-button type="success" icon="el-icon-circle-plus-outline" size="large" round>新增</el-button>
        </router-link>
      </el-col>
      <el-table :summary-method="getSummaries" show-summary stripe ref="multipleTable" :data="list.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))" style="width: 100%" :default-sort = "{prop: 'id', order: 'descending'}" max-height="550" @selection-change="handleSelectionChange">
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

        <el-table-column prop="alumniPhone" label="联系电话">
        </el-table-column>
        <el-table-column prop="alumniMail" label="邮件">
        </el-table-column>
        <el-table-column prop="alumniCompany" label="所在公司">
        </el-table-column>
        <el-table-column prop="alumniMotto" label="自我介绍">
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
              @click="updateAlumni(scope.$index, scope.row)">修改</el-button>
            <el-button
              size="mini"
              type="danger"
              @click.native.prevent="deleteAlumni(scope.$index, scope.row)">删除</el-button>
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
      return row.gender === value
    },
    filterHandler (value, row, column) {
      const property = column['property']
      return row[property].substring(0, 7) === value
    },
    getSummaries (param) {
      const { columns, data } = param
      const sums = []
      columns.forEach((column, index) => {
        if (index === 0) {
          sums[index] = '总计'
          return
        }
        if (index === 1) {
          sums[index] = columns.amount
          return
        }
        const values = data.map(item => Number(item[column.property]))
        if (!values.every(value => isNaN(value))) {
          sums[index] = values.reduce((prev, curr) => {
            const value = Number(curr)
            if (!isNaN(value)) {
              return prev + curr
            } else {
              return prev
            }
          }, 0)
          sums[index] += ' 元'
        } else {
          sums[index] = 'N/A'
        }
      })

      return sums
    }
  }
}
</script>
<style>

</style>
