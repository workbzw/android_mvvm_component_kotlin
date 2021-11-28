package com.work.module_base_custom

/**
 * @author bzw [workbzw@outlook.com]
 * @date   2021/11/28 10:39 下午
 * @desc   [ 路由映射]
 */
interface RouterPath {

    interface APP {
        companion object {
            const val GROUP_PATH = "/app"

            /**首页主页*/
            const val MAIN = "${GROUP_PATH}/main"
        }
    }

    interface HOME {
        companion object {
            const val GROUP_PATH = "/home"

            /**首页主页*/
            const val HOME = "${GROUP_PATH}/home"

            /**详情页*/
            const val DETAIL = "${GROUP_PATH}/detail"
        }
    }

    interface NOTIFICATION {
        companion object {
            const val GROUP_PATH = "/notification"

            /**首页主页*/
            const val HOME = "${GROUP_PATH}/home"
        }
    }

    interface DASHBOARD {
        companion object {
            const val GROUP_PATH = "/dashboard"

            /**首页主页*/
            const val HOME = "${GROUP_PATH}/home"
        }
    }

    interface USER {
        companion object {
            const val GROUP_PATH = "/user"

            /**首页`我的`入口*/
            const val HOME = "${GROUP_PATH}/home"

            /**设置*/
            const val SETTING = "${GROUP_PATH}/setting"
        }
    }

    interface LOGIN {
        companion object {
            const val GROUP_PATH = "/login"

            /**首页`登录`入口*/
            const val HOME = "${GROUP_PATH}/home"

            /**注册*/
            const val REGISTER = "${GROUP_PATH}/register"
        }
    }
}