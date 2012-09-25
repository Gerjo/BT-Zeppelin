
byte pinMotorA[] = {
  5, 6};
byte pinMotorB[] = {
  10, 11};

byte stateMotorA[] = {
  LOW, LOW};
byte stateMotorB[] = {
  LOW, LOW};

byte safetyDelay = 100;

void setup() {
  for(byte i = 0; i <= 1; ++i) {
    // Set pin type to OUPUT:
    pinMode(pinMotorA[i], OUTPUT);
    pinMode(pinMotorB[i], OUTPUT);

    // Set the default state to LOW (off):
    digitalWrite(pinMotorA[i], LOW);
    digitalWrite(pinMotorB[i], LOW);
  }

  Serial.begin(115200);
  Serial.println("BT Zeppelin omnidirectional driver ready."); 
}

void loop() {
  while(Serial.available()) {
    boolean update = true;
    int     input  = Serial.read();
    switch((char) input) {
    case 'q': // Motor A Left:
      digitalWrite(pinMotorA[0], LOW);
      delay(safetyDelay);
      digitalWrite(pinMotorA[1], HIGH);
      break;
    case 'w': // Motor A right:
      digitalWrite(pinMotorA[1], LOW);
      delay(safetyDelay);
      digitalWrite(pinMotorA[0], HIGH);
      break;
    case 'e': // Motor A off:
      digitalWrite(pinMotorA[0], LOW);
      digitalWrite(pinMotorA[1], LOW);
      break;
    
    case 'a': // Motor B Left:
      digitalWrite(pinMotorB[0], LOW);
      delay(safetyDelay);
      digitalWrite(pinMotorB[1], HIGH);
      break;
    case 's': // Motor B right:
      digitalWrite(pinMotorB[1], LOW);
      delay(safetyDelay);
      digitalWrite(pinMotorB[0], HIGH);
      break;
    case 'd': // Motor B off:
      digitalWrite(pinMotorB[0], LOW);
      digitalWrite(pinMotorB[1], LOW);
      break;
    
    
    case 'p': Serial.println("p"); break; // Used for ping
    case 'y': Serial.println("z"); break; // Used for handshake
      
    default:
      update = false;
      break;
    }
    //Serial.print((update));
    //Serial.print(" ");
    //Serial.println((char) input);
  } 
}




