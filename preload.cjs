const { contextBridge, ipcRenderer } = require('electron');
contextBridge.exposeInMainWorld('aerologDesktop', {
  onRosterCsv: (callback) => ipcRenderer.on('roster-csv-detected', (_event, file) => callback(file)),
  onLatestJson: (callback) => ipcRenderer.on('latest-json-detected', (_event, file) => callback(file)),
  openFile: (filePath) => ipcRenderer.invoke('open-roster-file', filePath),
  readFile: (filePath) => ipcRenderer.invoke('read-roster-file', filePath)
});