# avaj-launcher
Simple implementation an aircraft simulation program based on the class diagram.

***
### ***Usage:***
* `git clone https://github.com/mshkliai/avaj-launcher.git`
* `cd avaj-launcher`
* `./Makefile`
* `java JavaPack.Main test (program performance will be written in simulation.txt)`

***

## Test file description:
The first line of the file contains a positive integer number. This number represents the
number of times the simulation is run. In our case, this will be the number of times a
weather change is triggered.
Each following line describes an aircraft that will be part of the simulation, with this
format: TYPE NAME LONGITUDE LATITUDE HEIGHT.
