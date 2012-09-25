#include <string.h>

byte leftEnginePin  = 11;
byte rightEnginePin = 12;

int leftEngineState  = LOW;
int rightEngineState = LOW;

int selectedPower = 1;
int normalPower   = 1;

boolean isTurboMode = false;

void setup() {
  pinMode(leftEnginePin, OUTPUT);
  pinMode(rightEnginePin, OUTPUT);
  
  Serial.begin(115200);
  Serial.println("Setup completed. BT Zeppelin up and running.");
}

void loop() {
  
  while(Serial.available()) {
    int foo = Serial.read();
    switch((char)foo) {
      case 'p':
        Serial.println("q");
       break;
      case 'y':
        Serial.println("z");
       break;
      case 'l':// Left engine toggle:
        Serial.println("l");
        leftEngineState = (leftEngineState == LOW) ? selectedPower:LOW;
        digitalWrite(leftEnginePin, leftEngineState);
       break;
      case 'r': // Right engine toggle:
        Serial.println("r");
        rightEngineState = (rightEngineState == LOW) ? selectedPower:LOW;
        digitalWrite(rightEnginePin, rightEngineState);   
       break;
      case 'o': // Both engines off:
        Serial.println("o");
        rightEngineState = leftEngineState = LOW;
        selectedPower = normalPower;
        digitalWrite(rightEnginePin, LOW);
        digitalWrite(leftEnginePin, LOW);
        break;
      default:
        Serial.println("unknown");
       break;
    }
  }

  
  //delay(1000);
}

