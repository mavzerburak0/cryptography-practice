# Kadir Burak Mavzer


import string
from random import randint


# A dictionary is created to associate letters A-Z to numbers 1-26
# Inverse alphabet dictionary is created for reverse lookup (holds the 
# reverse of alphabet dict)

alphabetDict = dict(zip(string.ascii_uppercase, range(1,27)))
inverseAlphabetDict = dict(zip(range(1,27), string.ascii_uppercase))

def encrypt(message):
    key = []
    keyNumbers = []
    messageNumbers = []
    cipher = []

    # Creating a random key as the same length of message

    for i in range(0, len(message)):
        num = randint(1, 26)
        a = inverseAlphabetDict.get(num)
        key.append(a)
        b = alphabetDict.get(a)
        keyNumbers.append(b)

    # Converting the message to numbers using the dictionary

    for l in message.upper():
        messageNum = alphabetDict.get(l)
        messageNumbers.append(messageNum)
    
    # List comprehension used for encryption formula: (Message + Key) mod 26

    messageKeySum = [(messageNumbers[i] + keyNumbers[i]) % 26 for i in range(0, len(messageNumbers))]

    # Finally converting the numbers to letters using the inverse 
    # alphabet dictionary

    for i in messageKeySum:
        l = inverseAlphabetDict.get(i + 1)
        cipher.append(l)
    encryptedMessage = ''.join(cipher)
    print("Random key that is used to encrypt the message: " + ''.join(key))
    print("Encrypted message: " + encryptedMessage)

def decrypt(cipher, key):
    cipherTextNumbers = []
    decryptKeyNumbers = []
    decryptedNumbers = []

    # Converting the given cipher into numbers using alphabet dictionary

    for l in cipher:
        a = alphabetDict.get(l)
        cipherTextNumbers.append(a)

    # Converting the given key into numbers

    for l in key:
        a = alphabetDict.get(l)
        decryptKeyNumbers.append(a)

    # List comprehension used for decryption formula: (Cipher - Key) mod 26
    decryptedNumbers = [(cipherTextNumbers[i] - decryptKeyNumbers[i]) % 26 for i in range(0, len(cipher))]
    decipheredTextList = []

    # Finally converting the numbers to letters

    for i in decryptedNumbers:
        l = inverseAlphabetDict.get(i - 1)
        decipheredTextList.append(l)
    deciphered = ''.join(decipheredTextList)  
    print("Decrypted message: " + deciphered.upper())

def main():

    # Since our alphabet dictionaries only include letters
    # numbers 1-9 and the space character are restricted
     
    restricted = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', " "]
    
    messageToEncrypt = input("Enter a message to encrypt: ")
    for i in messageToEncrypt:
        if i in restricted:
            print("Message cannot include numbers or space.")
            main()
        else:
            continue
    encrypt(messageToEncrypt)
    messageToDecrypt = input("Enter a the message to decrypt: ")
    encryptionKey = input("Enter the key that is used to encrypt the message: ")
    if (len(messageToDecrypt) != len(encryptionKey)):
        print("Key and the message must be of the same length.")
        main()
    else:
        decrypt(messageToDecrypt, encryptionKey)

main()