import java.time.LocalDate

data class ShowDetail(
        val name: String,
        val id: Int,
        val description: String,
        var assets: MutableList<ShowAsset>
)

interface ShowAsset {
    val name: String
    val id: Int
    val type: String
    val url: String
    val expirationDate: LocalDate
}

data class ShowAssetVideo(
        override val name: String,
        override val id: Int,
        override val type: String,
        override val url: String,
        override val expirationDate: LocalDate,
        val videoType: String
) : ShowAsset


data class ShowAssetAd(
        override val name: String,
        override val id: Int,
        override val type: String,
        override val url: String,
        override val expirationDate: LocalDate,
        val description: String
) : ShowAsset

data class ShowAssetImage(
        override val name: String,
        override val id: Int,
        override val type: String,
        override val url: String,
        override val expirationDate: LocalDate,
        val baseAsset: String = "../assets/img0.png"
) : ShowAsset

fun main(args: Array<String>){
    val myShow0 = ShowDetail("Chuck", 0, "Nerd goes on spy adventure", mutableListOf<ShowAsset>())

    val myShow1 = ShowDetail( "House", 1, "Rude doctor saves day", mutableListOf<ShowAsset>())



    val adAsset0 = ShowAssetAd("chuckShortAd", 0, "AD", "www.showtime.com/ad00", LocalDate.parse("2019-02-12"), "30 second ad for Churk Movie")

    val adAsset1 = ShowAssetAd("houseShortAd", 1, "AD", "www.showtime.com/ad01", LocalDate.parse("2019-02-12"), "30 second ad for House reboot")

    val imageAsset0 = ShowAssetImage("Chuck Poster", 2, "Image", "www.showtime.com/image01", LocalDate.parse("2020-05-24"), "../assets/img3.png")

    val imageAsset1 = ShowAssetImage("House Poster 2", 3, "Image", "www.showtime.com/image00", LocalDate.parse("2020-02-02"))

    val videoAsset0 = ShowAssetVideo("Chuck Movie", 4, "Video", "www.showtime.com/video01", LocalDate.parse("2019-02-14"), "Movie")

    val videoAsset1 = ShowAssetVideo("House Clip",5, "Video", "www.showtime.com/video02", LocalDate.parse("2019-06-15"), "Clip")

    val videoAsset2 = ShowAssetVideo("House Episode 4", 6, "Video", "www.showtime.com/episodes/house04", LocalDate.parse("2019-01-15"), "Episode")

    myShow0.assets.add(adAsset0)
    myShow0.assets.add(imageAsset0)
    myShow0.assets.add(videoAsset0)

    myShow1.assets.add(adAsset1)
    myShow1.assets.add(imageAsset1)
    myShow1.assets.add(videoAsset1)
    myShow1.assets.add(videoAsset2)

    println(myShow0)

    println(myShow1)

    myShow0.assets.forEach { asset -> println(asset) }

    myShow1.assets.forEach { asset -> println(asset) }
}





