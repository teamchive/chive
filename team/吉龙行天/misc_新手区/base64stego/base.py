b64c = dict((__, _) for _, __ in enumerate('ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/'))
sss = list(filter(lambda _: _, open('stego.txt', 'r', encoding='utf-8').read().split('\n')))
out = ''.join('' if '=' not in s else ''.join(bin(b64c[_])[2:] for _ in s.strip('='))[-s.count('=')*2:] for s in sss)
while len(out) > 0:
    print(chr(int(out[:8], base=2)%128), end='')
    out = out[8:]
