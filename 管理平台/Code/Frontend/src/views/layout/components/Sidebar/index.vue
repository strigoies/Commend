<template>
  <el-scrollbar wrap-class="scrollbar-wrapper">
    <el-menu
      :show-timeout="200"
      :default-active="$route.path"
      :collapse="isCollapse"
      mode="vertical"
      background-color="#BC8F8F"
      text-color="#fff"
      active-text-color="#ffd04b"
      router="true"
      icon:true
    >
     <!-- background-color="#304156"
      text-color="#bfcbd9"
      active-text-color="#409EFF" -->
      <sidebar-item v-for="route in routes" :key="route.path" :item="route" :base-path="route.path"/>
      <div class="async-link" v-if="this.$store.state.isLogin">
      <el-menu-item index="/userManager" route icon:true>用户管理</el-menu-item>
      <el-menu-item index="/teacher" route>数据管理</el-menu-item>
      </div>
    </el-menu>
    <!-- <el-menu
      :show-timeout="200"
      :default-active="$route.path"
      :collapse="isCollapse"
      mode="vertical"
      background-color="#304156"
      text-color="#bfcbd9"
      active-text-color="#409EFF"
    >
      <sidebar-item v-for="list in  menulist" :key="list.path" :item="route" :base-path="list.path"/>
      </el-menu> -->
  </el-scrollbar>
</template>

<script>
import { asyncRoutes, constantRoutes } from '@/router/index'
import { mapGetters } from 'vuex'
import SidebarItem from './SidebarItem'
import loginApi from '@/api/loginuser'
export default {
  data(){
   return{ 
     menulist:[
         {
        path: '/userManager',
        //component: Layout,
        //redirect: '/teacher/table',
        name: '用户管理',
        meta: { title: '用户管理', icon: 'example',roles: ['admin'] },
        children: [

            {
                path: 'userManager',
                name: '用户管理',
                component: () =>
                    import ('@/views/edu/teacher/userManager'),
                meta: { title: '用户管理', icon: 'tree',roles: ['admin'] }
            },
            {
                path: 'edituser/:id',
                name: 'EduTeacherEdit',
                component: () =>
                    import ('@/views/edu/teacher/saveUser1'),
                meta: { title: '编辑讲师', noCache: true,roles: ['admin'] },
                hidden: true
            }
        ]
    },
    {
        path: '/teacher',
        //component: Layout,
        redirect: '/teacher/table',
        name: '管理',
        meta: { title: '管理', icon: 'example',roles: ['admin'] },
        children: [{
                path: 'table',
                name: '数据管理',
                component: () =>
                    import ('@/views/edu/teacher/list'),
                meta: { title: '数据管理', icon: 'table',roles: ['admin'] },
                //hidden: true
            },
            
            {
                path: 'save',
                name: '添加用户',
                component: () =>
                    import ('@/views/edu/teacher/save'),
                meta: { title: '添加用户', icon: 'tree',roles: ['admin'] },
                hidden: true
            },
            {
                path: 'edit/:id',
                name: 'EduTeacherEdit',
                component: () =>
                    import ('@/views/edu/teacher/save'),
                meta: { title: '编辑讲师', noCache: true,roles: ['admin'] },
                hidden: true
            }
        ],
        hidden: true
    },
    {
        path: '/form',
        //component: Layout,
        children: [{
            path: 'index',
            name: '数据管理',
            component: () =>
                import ('@/views/dataManager/dataManager'),
            meta: { title: '数据管理', icon: 'form',roles: ['admin'] }
        }
        
    ]
    },
    { path: '*', redirect: '/404', hidden: true }
    ]
  }},
  components: { SidebarItem },
  // data(){
  //     return{
  //       menus:[],
  //       routes1:[]
  //     }
  // },
  computed: {
    ...mapGetters([
      'sidebar',
      //'permission_routes'
    ]),
    routes() {
      //console(this.$router.options.routes)
      return this.$router.options.routes
      return asyncRoutes
    },
    isCollapse() {
      return !this.sidebar.opened
    }
  },
  // methods:{
  //   info(){
  //     loginApi.getLoginUserInfo()
  //               .then(response => {
  //                 //this.loginInfo = response.data.userInfo
  //                 console.log(response.data.userInfo)
  //                 console.log(response.data.userInfo.sign)
  //                 //获取返回用户信息，放到cookie里面
  //                 cookie.set('guli_ucenter',response.data.userInfo,{domain: 'localhost'})
  //                 if(response.data.userInfo.sign==="管理员"){
  //                   //this.constantRouterMap=constantRouterMap.concat(asyncRouterMap)
  //                     //Router.addRoutes(constantRouterMap.concat(asyncRouterMap))
  //                     var array=constantRouterMap.concat(asyncRouterMap)
  //                     //console.log(this.routeruser)
  //                     console.log(constantRouterMap)
  //                     const routes1=constantRouterMap.concat(asyncRouterMap)
  //                     router.addRoutes(routes1)
  //                 }
  //               })
  // }
  // },
  // mounted(){
  //   this.menus=routes1
  // }
}
</script>
