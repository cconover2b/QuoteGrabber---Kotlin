import java.net.HttpURLConnection
import java.net.URL
import java.util.*

fun main() {
    try {
        //API used:
        //https://run.mocky.io/v3/b2772cea-c31a-4630-836c-a4c9853d6132
        val url = URL("https://run.mocky.io/v3/b2772cea-c31a-4630-836c-a4c9853d6132")
        val conn = url.openConnection() as HttpURLConnection
        conn.requestMethod = "GET"
        conn.connect()
    
        //See if connection is made  
        val responseCode = conn.responseCode
    
        //200 is ok
        if (responseCode != 200) {
            throw RuntimeException("HttpResponseCode: $responseCode")
        } else {
            //Create an array for the API items
            val informationString = ArrayList<String>()

            //Open the API scanner and add items to the array
            val scanner = Scanner(url.openStream())
            while (scanner.hasNext()) {
                informationString.add(scanner.nextLine())
            }
    
            //Close the scanner
            scanner.close()

            //Prints the array
            print(informationString)

        // Prints the information in nicer format
        print("\n\nNicer format:\n\n")

        for (item in informationString) {
            println(item)
        }
        }

    // Catch and exception
    } catch (e: Exception){
        e.printStackTrace()
    }
}
