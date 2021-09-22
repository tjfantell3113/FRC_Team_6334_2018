# Team 6334 - Aluminati

Team 6334's 2018 FRC bot source code.

Read this:
- You are __**NOT**__ to replicate or use this code without proper permission from a ranking team member.
- More to come.
- You are to branch off of **master** if you're making a module/something that doesn't affect main bot code.
- You are to make a **merge request** proposing to merge your branch into **development**! Merge requests going to the master branch will be redirected to the **development** branch.
- Do **NOT** directly commit to either the master or development unless it's an EMERGENCY! Please instead make a new branch off of master or development, and merge request it back into development.
- You MUST install CTRE Talon SRX firmware, and wpilib to gain full functionality with this code.
Styleguide info will be established later, along with proper merge request formatting.

# About the code

This code is the team's attempt at going from basic hardcoding from the previous year to a more intelligent robot utilizing sensors and a command / subsystem architecture. Although it is a large leap from the previous year's code, there are still plenty of flaws in the code that could be improved upon. 

Basic info:
- The subsystems control the physical parts of the robot, like the lift or drive train.
- The commands are routines that can be called in order to make to robot perform certain actions.
- The robot uses a control scheme called arcade drive. This control scheme maps the inputs of one joystick to a tank drive control scheme, which normally requires two sticks for left and right wheel control.
- There is very primative OpenCV vision code to try and find cubes on the field during autonomous mode. Although the system works at times, the PID values are not tuned correctly causing much more trouble than help at times.
- In the code base is some path planning code that was never developed fully due to time contraints. Much like the vision code, the PID values are not tuned correctly causing more trouble than help at times.
