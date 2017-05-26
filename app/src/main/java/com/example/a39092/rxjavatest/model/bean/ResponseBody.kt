package com.example.a39092.rxjavatest.model.bean

/**
 * Created by 39092 on 2017/4/5.
 */

class ResponseBody {


    var count: Int = 0
    var start: Int = 0
    var total: Int = 0
    var title: String? = null
    var subjects: List<SubjectsBean>? = null

    override fun toString(): String {
        return "ResponseBody{" +
                "count=" + count +
                ", start=" + start +
                ", total=" + total +
                ", title='" + title + '\'' +
                ", subjects=" + subjects +
                '}'
    }

    class SubjectsBean {

        var rating: RatingBean? = null
        var title: String? = null
        var collect_count: Int = 0
        var original_title: String? = null
        var subtype: String? = null
        var year: String? = null
        var images: ImagesBean? = null
        var alt: String? = null
        var id: String? = null
        var genres: List<String>? = null
        var casts: List<CastsBean>? = null
        var directors: List<DirectorsBean>? = null

        override fun toString(): String {
            return "SubjectsBean{" +
                    "rating=" + rating +
                    ", title='" + title + '\'' +
                    ", collect_count=" + collect_count +
                    ", original_title='" + original_title + '\'' +
                    ", subtype='" + subtype + '\'' +
                    ", year='" + year + '\'' +
                    ", images=" + images +
                    ", alt='" + alt + '\'' +
                    ", id='" + id + '\'' +
                    ", genres=" + genres +
                    ", casts=" + casts +
                    ", directors=" + directors +
                    '}'
        }

        class RatingBean {


            var max: Int = 0
            var average: Double = 0.toDouble()
            var stars: String? = null
            var min: Int = 0

            override fun toString(): String {
                return "RatingBean{" +
                        "max=" + max +
                        ", average=" + average +
                        ", stars='" + stars + '\'' +
                        ", min=" + min +
                        '}'
            }
        }

        class ImagesBean {


            var small: String? = null
            var large: String? = null
            var medium: String? = null

            override fun toString(): String {
                return "ImagesBean{" +
                        "small='" + small + '\'' +
                        ", large='" + large + '\'' +
                        ", medium='" + medium + '\'' +
                        '}'
            }
        }

        class CastsBean {


            var alt: String? = null
            var avatars: AvatarsBean? = null
            var name: String? = null
            var id: String? = null

            class AvatarsBean {


                var small: String? = null
                var large: String? = null
                var medium: String? = null

                override fun toString(): String {
                    return "AvatarsBean{" +
                            "small='" + small + '\'' +
                            ", large='" + large + '\'' +
                            ", medium='" + medium + '\'' +
                            '}'
                }
            }
        }

        class DirectorsBean {


            var alt: String? = null
            var avatars: AvatarsBeanX? = null
            var name: String? = null
            var id: String? = null

            class AvatarsBeanX {
                /**
                 * small : https://img3.doubanio.com/img/celebrity/small/230.jpg
                 * large : https://img3.doubanio.com/img/celebrity/large/230.jpg
                 * medium : https://img3.doubanio.com/img/celebrity/medium/230.jpg
                 */

                var small: String? = null
                var large: String? = null
                var medium: String? = null

                override fun toString(): String {
                    return "AvatarsBeanX{" +
                            "small='" + small + '\'' +
                            ", large='" + large + '\'' +
                            ", medium='" + medium + '\'' +
                            '}'
                }
            }
        }
    }
}
