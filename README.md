# SteamMarketScraper
Scrapes Steam Market API on Professional/Specialized Killstreak Fabricators+Kits


//                Project Notes                 \\

!!!THE STEAM MARKET API!!!

The Steam Market API has very little documentation on how it functions,
the majority of information on the API was obtained by trial and error
and from random people on github who had some information.

When searching on the Steam Market, the search bar auto-fills the information
that you used in the search to a custom url. When accessing the API, this url
differs slightly.

--> For example, when sorting by name/price etc., at the end of the Steam 
Market search url ends with something like #p1_name_asc, which I believe is
a javascript function that isn't available when getting a .json file from
the API. In the API link, you have to alter the search params IN the URl.
In order to get an ordered json by name, you must put 
'&sort_column=name&sort_dir=asc" in the URL, which will alter the params
of the JSON to order it in order.

Here is a link to all of the params attributes you can edit in the URL:
https://gist.github.com/bertrandmartel/ff498db51c36cc227b7a186c521bc78a

Additionally, Steam does not like it if you bombard it with requests.
For this reason, I have limited the page requests to once every 5 seconds
to prevent a return code of 503 (meaning they shut you off for a minute).
This makes the program slow, as it accesses about 8 pages to function, so
in total that is ~40 seconds for it to generate the information.

I began this project with no knowledge of JSON files, deserialization,
binding, and Properties. Through this project I was able to undestand
those topics and I am grateful that I figured out how to do all of this
stuff lol.

//                Running Notes                 \\

Apart from jre1.8.0, the two libraries I am using in this project are
JavaFX and Gson (A .JSON parser from Google). You may need to download
these for your program to work.

I plan on compiling it into a .exe to launch.

Programmed in about 3 days.
