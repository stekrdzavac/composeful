# Composeful

Composeful is library containing widget built using Jetpack Compose representing some common use
cases where standard library widgets do not have desired behavior.

## ProgressButton

ProgressButton is button which shows loading indicator while disabling button for click action
during e.g. loading data from API, or some other long operation which is trigered by button click.

![Button](https://media.giphy.com/media/Ergz2M1gfL9o9Bdgt1/giphy.gif)

Usage:

```kotlin
ProgressButton(
    onButtonClick = {
        loading1 = !loading1
        coroutineScope.launch {
            delay(3000)
            loading1 = !loading1
        }
    },
    loading = loading1,
    modifier = Modifier.fillMaxWidth().padding(8.dp).align(CenterHorizontally)
) {
    Icon(
        imageVector = Icons.Default.PlayCircle,
        contentDescription = "Play Button",
        modifier = Modifier.size(88.dp)
    )
}
```