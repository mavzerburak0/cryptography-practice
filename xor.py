
# Cryptography XOR practice

# Take input from user for a message to encrypt with one time pad
message = input("Type in a message to encrypt: ")

# Binary representation of every letter in the message as a python list
message = [bin(ord(c)) for c in message]
#print(message)

# Key can be randomized however for the sake of simplicity, it is hard-coded
key = '0b1001011'

# encrypt method creates an empty python list named cipher
# and for every binary number in the first argument, it
# creates a variable named cipher_message which holds the xor'ed
# binary values of each element in the list x, i.e. each letter
# of the message. Then, appends these values to the previously created
# cipher list, and finally returns this list

def encrypt(x, y):
    cipher = []
    cipher_text = []
    for i in x:
        cipher_message = bin(int(i, 2) ^ int(y, 2))
        cipher.append(cipher_message)
    
    for i in cipher:
        i = int(i, 2)
        cipher_text.append(i.to_bytes((i.bit_length() + 7) // 8, 'big').decode())
    print("Encrypted message:")
    print(''.join(cipher_text) + "\n")
    
    return cipher

# decrypt method first takes the ciphered message from the encrypt
# method and creates an empty python list named bin_message (to hold
# the binary representation of the decrypted message) and message (to
# hold the fully decrypted message) then reverses what has been done
# in the encrypt method above. Finally, it converts the binary into
# ascii representation of the message, then prints it out.

def decrypt(y):
    cipher = encrypt(message, key)
    bin_message = []
    decrypted_message = []
    for i in cipher:
        decipher_message = bin(int(i, 2) ^ int(y, 2))
        bin_message.append(decipher_message)
    for i in bin_message:
        i = int(i, 2)
        decrypted_message.append(i.to_bytes((i.bit_length() + 7) // 8, 'big').decode())
    print("Decrypted message:")
    print(''.join(decrypted_message))

decrypt(key)
