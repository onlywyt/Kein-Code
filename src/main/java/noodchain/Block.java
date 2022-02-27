package noodchain;

import java.util.Date;

/**
 * @program: source-demo
 * @description: 组成区块链的类
 * @ClassName：Block
 * @author: Mr.Wang
 * @create: 2022-02-27 17:18
 **/
public class Block {

    public String hash;//保存我们的数字签名
    public String previousHash;//保存前一个block的数字签名
    private String data;//保存我们的块数据的变量
    private long timestamp;//自 1970 年 1 月 1 日以来的毫秒数
    //实际上，每个矿工都会从一个随机点开始迭代。一些矿工甚至可能会尝试随机数。另外值得注意的是，
    // 在更困难的解决方案中可能需要超过 integer.MAX_VALUE，然后矿工可以尝试更改时间戳。
    private int nonce;


    public Block(String data, String previousHash){
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = new Date().getTime();
        this.hash = calculateHash();
    }

    //使用我们的applySha256助手来计算哈希值
    public String calculateHash(){
        String calculatedHash = StringUtil.appluSha256(
                previousHash +
                        timestamp +
                        nonce +
                        data
        );
        return calculatedHash;
    }

    /**
     *
     * mineBlock ()方法接受一个称为难度的整数，这是他们必须解决的 0 的数量。
     * 在大多数计算机上几乎可以立即解决像 1 或 2 这样的低难度，我建议在 4-6 左右进行测试。在撰写本文时，莱特币的难度约为 442,592。
     */
    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0"
        while(!hash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }
}
