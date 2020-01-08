package com.zky.basics.common.util.localShow



class Album {
    companion object {
        var type = ""
            private set
        private var name = ""

        fun image(): Companion {
            type = "image"
            name = "图片文件"
            return this
        }

        var isShortVideo = false
            private set
        var shortVideoMin = -1
            private set

        fun video() = Companion.video(false, -1)
        fun video(isShortVideo: Boolean, shortVideoMin: Int): Companion {
            this.isShortVideo = isShortVideo
            this.shortVideoMin = shortVideoMin
            type = "video"
            name = "视频文件"
            return this
        }


        var requestCode = 0
            private set

        fun requestCode(requestCode: Int): Companion {
            this.requestCode = requestCode
            return this
        }

        var camera = true
            private set

        fun camera(camera: Boolean): Companion {
            this.camera = camera
            return this
        }

        var columnCount = 2
            private set

        fun columnCount(columnCount: Int): Companion {
            this.columnCount = columnCount
            return this
        }

        var selectCount = 9
            private set

        fun selectCount(selectCount: Int): Companion {
            this.selectCount = selectCount
            return this
        }

        var size = -1L
            private set

        fun size(size: Long): Companion {
            this.size = size
            return this
        }

        var duration = -1L
            private set

        fun duration(duration: Long): Companion {
            this.duration = duration
            return this
        }

        var checkedList = arrayListOf<AlbumFile>()
            private set

        fun checkedList(checkedList: List<AlbumFile>): Companion {
            this.checkedList.addAll(checkedList)
            return this
        }

        var onResult: Action? = null
            private set

        fun onResult(action: Action): Companion {
            this.onResult = action
            return this
        }

//        fun start(activity: Activity) {
//            FragmentsActivity.startFragmentsActivity(
//                activity,
//                FragmentsActivity.LOCALSHOW,
//                name
//            )
//        }

        fun reset() {
            type = ""
            name = ""
            isShortVideo = false
            shortVideoMin = -1
            size = -1
            duration = -1
            requestCode = 0
            camera = true
            columnCount = 2
            selectCount = 0
            checkedList.clear()
            onResult = null
        }

        interface Action {
            fun onAction(requestCode: Int, result: List<AlbumFile>)
        }
    }
}