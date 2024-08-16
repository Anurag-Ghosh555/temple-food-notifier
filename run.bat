@echo off
javac -cp twilio-10.0.0-jar-with-dependencies.jar SendSMS.java

java -cp ".;twilio-10.0.0-jar-with-dependencies.jar" SendSMS

