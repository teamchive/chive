## Write-up

根据密文格式倒不难推断是栅栏密码，关键问题是判断具体的种类。

首先，从y和b的位置基本可以推断出不是|||型栅栏而是WWW型。

继而，根据攻防世界flag的格式和密文中y的位置，可以推断出第一行为ccehg。

尝试若干次后，发现，只有栅栏行数为5时能满足第一行为ccehg且能观察出cyberpeace的要求。

按此规律得flag为cyberpeace{railfence_cipher_gogogo}