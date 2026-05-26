@echo off
setlocal enabledelayedexpansion

rem Clean and create bin directory if it doesn't exist
if not exist bin mkdir bin

echo ===================================================
echo   Compiling GUIProject Java files...
echo ===================================================

rem Compile Swing and AWT classes
javac -d bin -sourcepath src src/hust/soict/hedspi/swing/*.java
if %errorlevel% neq 0 (
    echo Error compiling Swing classes.
    pause
    exit /b %errorlevel%
)

rem Compile JavaFX classes
javac -d bin -sourcepath src --module-path lib --add-modules javafx.controls,javafx.fxml src/hust/soict/hedspi/javafx/*.java
if %errorlevel% neq 0 (
    echo Error compiling JavaFX classes.
    pause
    exit /b %errorlevel%
)

rem Copy non-java resource files (like .fxml) from src to bin
xcopy src\*.fxml bin\ /s /y /i >nul 2>&1

echo Compilation successful!
echo.
:menu
echo Please select the application to run:
echo 1. AWTAccumulator
echo 2. SwingAccumulator
echo 3. NumberGrid
echo 4. Painter (JavaFX)
echo 5. Exit
echo.

set /p choice="Enter your choice (1-5): "

if "%choice%"=="1" (
    echo Running AWTAccumulator...
    java -cp bin hust.soict.hedspi.swing.AWTAccumulator
    goto menu
) else if "%choice%"=="2" (
    echo Running SwingAccumulator...
    java -cp bin hust.soict.hedspi.swing.SwingAccumulator
    goto menu
) else if "%choice%"=="3" (
    echo Running NumberGrid...
    java -cp bin hust.soict.hedspi.swing.NumberGrid
    goto menu
) else if "%choice%"=="4" (
    echo Running Painter...
    java -cp "bin;lib/*" --module-path lib --add-modules javafx.controls,javafx.fxml hust.soict.hedspi.javafx.Painter
    goto menu
) else if "%choice%"=="5" (
    echo Exiting.
) else (
    echo Invalid choice.
    goto menu
)

endlocal
