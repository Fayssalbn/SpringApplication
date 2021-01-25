@ECHO OFF
@echo Started: %date% %time%
git commit -m "Updated "
git push --force origin master
@echo Completed: %date% %time%


