# Toaster
Android Library for customizing toast messages


[![](https://jitpack.io/v/tlarsin/Toaster.svg)](https://jitpack.io/#tlarsin/Toaster)


## Setup

In your root `build.gradle` add the following

```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

## Dependency

```
dependencies {
	     ...
	     implementation 'com.github.tlarsin:Toaster:Tag'
}
	
```

## Usage

```
Toaster(context: Context).show(message: String)
```

This will show the default style Toast.
