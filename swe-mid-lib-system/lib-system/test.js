const { exec } = require('child_process');
const fs = require('fs');

// 從命令行引數中獲取指令和檔案路徑
const commandToRun = process.argv[2];
const filePath = process.argv[3];

// 檢查引數是否提供正確
if (!commandToRun || !filePath) {
    console.error('請提供正確的指令和文字檔路徑！');
    console.log('用法: node test.js "your_command_here" "path/to/your/textfile.txt"');
    process.exit(1);
}

// 讀取文字檔的內容
const expectedOutput = fs.readFileSync(filePath, 'utf-8');

// 執行指令
exec(commandToRun, (error, stdout, stderr) => {
    if (error) {
        console.error(`執行指令時發生錯誤: ${error}`);
        return;
    }

    // 比較 stdout 與預期輸出
    if (stdout.trim() === expectedOutput.trim()) {
        console.log('stdout 與預期輸出相符！');
    } else {
        console.log('stdout 與預期輸出不符合。');
        console.log('預期輸出:');
        console.log(expectedOutput);
        console.log('實際輸出:');
        console.log(stdout);
    }
});
