#RecyclerView Adapter

![Bottom Navigation](https://drive.google.com/open?id=12KvVmbr1wE5cs7zFe7aj2HIlLqm2XJrJ)

`RecyclerAdapter` is a wrapper above the default `RecyclerView.Adapter` which handles the layout inflation and binding the data to the view.

##API Documentation

The `RecyclerAdapter` accepts the `List<AdapterItem>`. The `AdapterItem` is a simple data class which holds the title and URL of the thumbnail to be shown.
In addition, the the single and long click events on an item can be listened by using `AdapterItemClickListener`.

A typical way of setting the adapter looks something like this:

```kotlin
adapter = RecyclerAdapter(itemList = adapterItems) 
```

####AdapterItem

**Title** - the title of the thumbnail. Left-aligned, Medium, 14sp

**ImageURL** - This holds the path to the thumbnail. It can be either a DrawableRes, local file path or a Url. The images from server are fetched using Picasso.

You can create an `AdapterItem` like this:

AdapterItem with DrawableRes as image path

```kotlin
AdapterItem("Title",ImageURL(resourcePath = R.drawable.ic_add_black_24dp))
```

AdapterItem with local path as image path

```kotlin
AdapterItem("Title",ImageURL(filePath = "file://$filePath"))
```

AdapterItem with URL as image path

```kotlin
AdapterItem("Title",ImageURL(url = "https://storage.googleapis.com/spec-host-backup/mio-design%2Fassets%2F1PrVPyUvR5HvW5KcvIIy9s3T52Vy9jwN9%2Fbottom-app-bar-intro.png"))
```


####AdapterItemClickListener

When an item in the recycler view is clicked (single tap), informed via `onItemClick` and when long pressed it is notified via `onItemLongClick`.

You can add the listener to adapter like this:

```kotlin
defaultAdapter.adapterItemClickListener = object : RecyclerAdapter.AdapterClickListener {
                override fun onItemClick(item: AdapterItem) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onItemLongClick(item: AdapterItem) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            }
```