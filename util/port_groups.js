#!/usr/bin/env node

var stdin = process.stdin,
    stdout = process.stdout,
    stderr = process.stderr,
    inputChunks = [];

stdin.resume();
stdin.setEncoding('utf8');

stdin.on('data', function (chunk) {
  inputChunks.push(chunk);
});

stdin.on('end', function () {
  var inputJs = inputChunks.join(), i, outputJson = { groups: [] };
  eval(inputJs);
  if (!groups) throw new Error('couldn\'t read the groups array');
  for (i = 0; i < groups.length; i++) {
    outputJson.groups.push({
      name: groups[i][0],
      url: groups[i][1],
      latitude: groups[i][2],
      longitude: groups[i][3],
      justScala: groups[i][4]
    });
  }
  stdout.write(JSON.stringify(outputJson, null, '  ') + '\n');
  stderr.write('entries in original groups.js: ' + groups.length + '\n');
  stderr.write('entries in output json:        ' + outputJson.groups.length + '\n');
});
