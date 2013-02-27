# W.R.T v2

OK, this is a port of the our entry to libGDX, which is a cross-platform game framework. I chose to make a new repository because the folder structure for this port is going to be really different, and I didn't like the idea of trying to rearrange an entire git repo.

I've set up both desktop and Android projects so far; though as of yet there is no working input for Android. It's on my to-do list.

## Run the game

To run it, you can either download a working jar file from the 'builds' folder, or you can pull the whole repository.

If you're pulling, you'll need to import all three sub-projects into eclipse (WRT2, WRT2-android and WRT2-desktop). From there you can just run WRT2-desktop's Main class to run the game. You can't run the WRT2 project, it just holds the shared code for the other two projects.

## libGDX

I won't finish this just now but I'll try and explain the structure of the project as well as libGDX's features etc.

### The WRT class in the WRT2 project
_com.optimism.wrt_

This is the class that the entry points of each platform will create and run. It should be fairly self-explanatory. It extends the class MainGame which is just an empty game class I made for convenience.

### The Main class in WRT2-desktop and the MainActivity class in WRT2-android
_com.optimism.wrt_

These are the entry points for their respective platforms. They configure the initial settings of the game and instantiate it.

### The GameState and StateManager classes
_com.optimism.wrt.engine_

GameStates perform the function that our massive JFrame class did in the project's previous incarnation. They contain the world (if there is one) and handle the mainloop while they are the active state.

The StateManager holds information about which State the game is in. The WRT class looks to the StateManager to call the run function of the current State. Each GameState also has a reference to the Manager, so to change state, you can either call `manager.pushState(newState)` to change to a new state or `manager.popState()` to return to the previous state.
