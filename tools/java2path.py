import os
import json

prefix = "\\"
target_path = rf"F:\android\Moe-Moe\aw_chromium\src\main\java"
allow_export = [
    "J",
    "org"
]
result = {}

def update_structure(target, source):
    for key, value in source.items():
        if key in target:
            if isinstance(target[key], dict) and isinstance(value, dict):
                update_structure(target[key], value)
            else:
                target[key] = [target[key], value]
        else:
            target[key] = value
    return target

for root, _, files in os.walk(target_path):
    for file in files:
        package_name = prefix.join(list(filter(None, root.replace(target_path, "").split(prefix))))
        if any(package_name.startswith(allow) for allow in allow_export):
            current = []
            for part in reversed(os.path.join(package_name, file).split(prefix)):
                current =  {part: current}
            result = update_structure(result, current)

json.dump(result, open(os.path.join(os.path.dirname(__file__), "structure.json"), "w"), indent=4, sort_keys=True)