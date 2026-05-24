Set-ItemProperty -Path "HKLM:\SOFTWARE\Classes\jarfile\shell\open\command" -Name "(default)" -Value "`"C:\Program Files\Java\jdk-25.0.2\bin\javaw.exe`" -jar `"%1`" %*"
Write-Host "Registry updated. JAR files will now open with Java 25."
Write-Host "Old value was: Java 8 (jre-1.8)"
Write-Host "New value is:"
Get-ItemProperty -Path "HKLM:\SOFTWARE\Classes\jarfile\shell\open\command" | Select-Object -ExpandProperty "(default)"
pause
