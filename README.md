# android_mvvm_component_kotlin

# android 组件化 mvvm kotlin

### 项目结构

```text
app:app主入口 需依赖 module_base 和所有 module_biz_xxx 模块
module_biz_xxx:业务模块 需依赖module_base
module_base:每个module必须依赖的下沉模块 依赖 module_base_custom 模块
module_base_custom:可随时定制化改动的base模块 依赖 module_base_standard 模块
module_base_standard:不可随意改动的标准化base模块
```

### 新建模块

```text
依赖module_base 
依赖ARouter 
引入arouter插件 
配置ARouter
引入kapt插件 
开启databinding 
配置资源文件前缀(防止组件化资源合并引起的资源id冲突)
```

### 新建Activity/Fragment

```text
继承BaseActivity/BaseFragment
实现setLayoutId()方法
实现init()方法(ViewModel和DataBinding已在Base中配置好 可以直接引用到)
layout必须转换为databinding Layout
layout id 必须符合前缀要求
配置Router(path="xxx") 在module_base_custom中存在 公共路由映射类:RouterPath
```

