# KeyboardVisibility for Android Kotlin

[ ![Download](https://api.bintray.com/packages/seachicken/maven/keyboard-visibility/images/download.svg?version=0.1) ](https://bintray.com/seachicken/maven/keyboard-visibility/0.1/link)

Handle keyboard visibility event for Android Kotlin.

![demo](.github/demo.gif)

## Usage

Add `setOnVisibleChangeListener` to Activity.

```kotlin
setOnVisibleChangeListener(object : KeyboardVisibility.VisibleChangeListener {
    override fun onShown() {
        Log.d("KeyboardVisibility", "keyboard is shown")
    }

    override fun onHidden() {
        Log.d("KeyboardVisibility", "keyboard is hidden")
    }
})
```

## Download

```groovy
dependencies {
    implementation 'com.oishiiseachicken.android:keyboardvisibility:0.1'
}
```