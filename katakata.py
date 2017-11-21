import readchar
from py4j.java_gateway import JavaGateway

def iter_chars(filename):

    with open(filename, encoding='utf-8') as f:
        content = f.read()
    for ch in content:
        yield ch

if __name__ == "__main__":
    with open('src/main/kotlin/ProcessingKt.Kt', encoding='utf-8') as f:
        content = f.read()
    for i in content:
        kb = readchar.readchar()
        if kb != 'q':
            print(i,end="",flush=True)
        else:
            gateway = JavaGateway()
            #AdditionApplicationのインスタンスを取得
            processing = gateway.entry_point
            # additionを呼び出し
            processing.run()
            break





